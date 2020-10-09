package com.microserviceuser.web.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.validation.Valid;


import com.microserviceuser.dao.ConfirmationEmailRepository;
import com.microserviceuser.dao.RoleRepository;
import com.microserviceuser.dao.UserRepository;
import com.microserviceuser.entities.ConfirmationEmailToken;
import com.microserviceuser.entities.ERole;
import com.microserviceuser.entities.Role;
import com.microserviceuser.entities.User;
import com.microserviceuser.payload.request.LoginRequest;
import com.microserviceuser.payload.request.SignupRequest;
import com.microserviceuser.payload.response.JwtResponse;
import com.microserviceuser.payload.response.MessageResponse;
import com.microserviceuser.security.jwt.JwtUtils;
import com.microserviceuser.security.services.EmailSenderService;
import com.microserviceuser.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;



@RestController
public class AuthController {


    private static final String PASSWORD__PATTERN = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?=\\\\S+$).{6,12}";

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    ConfirmationEmailRepository confirmationEmailRepository;

    @Autowired
    EmailSenderService emailSenderService;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    private JavaMailSender javaMailSender;



    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }

    @RequestMapping(value = "/confirm-account", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<?> confirmUserAccount(@RequestParam("token") String confirmationToken) {
        ConfirmationEmailToken token = confirmationEmailRepository.findByConfirmationToken(confirmationToken);

        if (token != null) {
            User user = new User();
            for (User userp:userRepository.findAll()) {
                if (userp.getEmail().equalsIgnoreCase(token.getUser().getEmail()) ) {
                    user = userp;
                    break;
                }
            }
            user.setActive(true);
            userRepository.save(user);

            return ResponseEntity.ok("Email verifié");
        } else {
            return ResponseEntity.ok("Error : Lien invalid ou expiré!");
        }
    }

    @PostMapping(value = "signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: cet identifiant est utilisé par un autre utilisateur!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: cet email est utilisé par un autre utilisateur !"));
        }
        if (validate(signUpRequest.getPassword())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Mot de passe non valide " +
                            "( 8 à 12 caractere,1 maj et 1 min , 1 chiffre et 1 symbole ) !"));
        }

        // Create new user's account
        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getNom(),
                signUpRequest.getPrenom(),
                signUpRequest.getPhone(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()), false);


        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role eleveRole = roleRepository.findByName(ERole.ROLE_ELEVE)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(eleveRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "parent":
                        Role parentRole = roleRepository.findByName(ERole.ROLE_PARENT)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(parentRole);

                        break;
                    case "prof":
                        Role profRole = roleRepository.findByName(ERole.ROLE_PROF)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(profRole);

                        break;
                    default:
                        Role eleveRole = roleRepository.findByName(ERole.ROLE_ELEVE)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(eleveRole);
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);
        try {
            sendConfirmationMail(user);
        } catch (Exception e) {
            e.getStackTrace();
        }
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    public boolean validate(final String password){

        Pattern pattern = Pattern.compile(PASSWORD__PATTERN,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(password);

        if(matcher.matches())
            return true;
        else
            return false;
    }


        @GetMapping(value = "/generatePassword/{mail}")
        public Boolean generatePassword(@PathVariable("mail") String mail) {
        User user=userRepository.findByEmail(mail);

        int MAX_LENGTH = 12;

        java.util.Random r = new java.util.Random();

        String DIGITS = "23456789";
        String LOCASE_CHARACTERS = "abcdefghjkmnpqrstuvwxyz";
        String UPCASE_CHARACTERS = "ABCDEFGHJKMNPQRSTUVWXYZ";
        String SYMBOLS = "@#$%=:?";
        String ALL = DIGITS + LOCASE_CHARACTERS + UPCASE_CHARACTERS;
        char[] upcaseArray = UPCASE_CHARACTERS.toCharArray();
        char[] locaseArray = LOCASE_CHARACTERS.toCharArray();
        char[] digitsArray = DIGITS.toCharArray();
        char[] symbolsArray = SYMBOLS.toCharArray();
        char[] allArray = ALL.toCharArray();

        StringBuilder sb = new StringBuilder();

        sb.append(locaseArray[r.nextInt(locaseArray.length)]);

        sb.append(upcaseArray[r.nextInt(upcaseArray.length)]);

        sb.append(digitsArray[r.nextInt(digitsArray.length)]);

        sb.append(symbolsArray[r.nextInt(symbolsArray.length)]);

        for (int i = 0; i < MAX_LENGTH - 4; i++) {
            sb.append(locaseArray[r.nextInt(locaseArray.length)]);
        }
        user.setPassword(encoder.encode(sb.toString()));
            userRepository.save(user);
            initPasswaordMail(sb.toString(),mail);
        return true;

    }




    private void initPasswaordMail(String toStrin,String mail) {

        String url = "https://www.wattsucces.com";
        String mailFrom = "postmaster@wattsucces.com";

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(mail);
        mailMessage.setSubject("Validation de votre demande de réinitialisation de mot de passe à Wattsucces");
        mailMessage.setFrom(mailFrom);
        mailMessage.setText("Bonjour,\n" +
                "\n" +
                "Vous avez demandé la réinitialisation de votre mot de passe.\n" +
                "Voici votre nouveau mot de passe pour vous connectez: "+toStrin+
                "\n" +
                "Cordialement\n "+
                "\n" +
                "L'équipe Wattsucces\n "+
                url
        );

        javaMailSender.send(mailMessage);

    }


    private void sendConfirmationMail(User user) {


        //send mail validation
        ConfirmationEmailToken confirmationEmailToken = new ConfirmationEmailToken(user);

        confirmationEmailRepository.save(confirmationEmailToken);

        String url = "https://www.wattsucces.com";
        String mailFrom = "postmaster@wattsucces.com";

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.getEmail());
        mailMessage.setSubject("Validation de votre demande d'inscription à Wattsucces");
        mailMessage.setFrom(mailFrom);
        mailMessage.setText("Bonjour,\n" +
                "\n" +
                "Vous avez demandé l'inscription à Wattsucces\n" +
                "Cliquez sur le lien suivant pour obtenir la validation de votre inscription :"  + url + "/confirm-account?token="+ confirmationEmailToken.getConfirmationToken()+
                "\n" +
                "Cordialement\n "+
                "\n" +
                "L'équipe Wattsucces\n "+
                url
               );

        javaMailSender.send(mailMessage);

    }


}
