package com.client.bean.profilU;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class ProfiluBean {

    int id;
    String question;
    String item;
    String dimention;
    String code;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ProfiluBean{");
        sb.append("id=").append(id);
        sb.append(", question='").append(question).append('\'');
        sb.append(", item='").append(item).append('\'');
        sb.append(", dimention='").append(dimention).append('\'');
        sb.append(", code='").append(code).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
