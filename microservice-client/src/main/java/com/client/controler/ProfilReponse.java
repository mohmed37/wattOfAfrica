package com.client.controler;

import com.client.bean.ProfiluBean;
import lombok.Data;

import java.util.List;

@Data
public class ProfilReponse {
    private List<ProfiluBean> content;
}
