package com.client.controler;

import com.client.bean.nDream.PhotoBean;
import com.client.proxy.MndreamProxy;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

@Controller
public class NdreamControler {
    @Autowired
    MndreamProxy mndream;
    @Value("${dir.images}")
    private String imageDir;

    @RequestMapping("/photos")
    public String formLivre(Model model){
        PhotoBean photo =new PhotoBean();
        model.addAttribute("photo",photo);
        return "photos";
    }

    @RequestMapping("/savePhoto")
    public String saveLivre(@Valid @ModelAttribute("photo") PhotoBean photo,
                            @RequestParam(name = "picture") MultipartFile file, BindingResult bindingResult) throws IOException {
        if (bindingResult.hasErrors()){
            return "photos";
        }

        List<PhotoBean>listPhoto=mndream.listPhotos();
        photo.setId(listPhoto.size()+1);

        if(!(file.isEmpty())){
            photo.setPhoto(file.getOriginalFilename());
            file.transferTo(new File(imageDir+(photo.getId())));
        }
        mndream.savePhoto(photo);
        return "redirect:/photos";

    }

    @RequestMapping(value = "bnDream")
    public String bnDream(Model model){
        List<PhotoBean>listPhoto=mndream.listPhotos();
        int idPhoto=listPhoto.size();
        int[]nombre=new int[idPhoto];
        for (int j=1;j<idPhoto;j++) nombre[j]=j;
        model.addAttribute("nombre",nombre);

        return "bnDream";
    }


    @RequestMapping(value = "/getPhoto",produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] getPhoto(String id) throws IOException {
        File f=new File(imageDir+id);
        return IOUtils.toByteArray(new FileInputStream(f));

    }


}
