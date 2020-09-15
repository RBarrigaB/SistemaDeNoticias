package com.edutecno.DesafioNoticias;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controlador {


	private final static Logger logger =
			LoggerFactory.getLogger(Controlador.class);
			@RequestMapping("/")
			public String Main(Model modelo) {
			String nombre = "src/main/resources/static/noticias.txt";
			ArrayList<String> p = new ArrayList<String>();
			try {
			FileReader fr = new FileReader(nombre);
			BufferedReader br = new BufferedReader(fr);
			String data = br.readLine();
			
			while (data != null) {					
				
				String[] data_filtro = data.split("@@");
				for(int i =0;i<data_filtro.length;i++) {
					p.add(data_filtro[i]);
				}
					
				data = br.readLine();
			}
			
			br.close();
			fr.close();
			} catch (Exception e) {
			logger.error("Error leyendo el fichero "+ nombre + ": " + e);
			}
			
			// Noticia 1
			modelo.addAttribute("noticia1_encabezado",p.get(0));
			modelo.addAttribute("noticia1_cuerpo",p.get(1));
			modelo.addAttribute("noticia1_url",p.get(2));
			//Noticia 2
			modelo.addAttribute("noticia2_encabezado",p.get(3));
			modelo.addAttribute("noticia2_cuerpo",p.get(4));
			modelo.addAttribute("noticia2_url",p.get(5));
			//Noticia 3
			modelo.addAttribute("noticia3_encabezado",p.get(6));
			modelo.addAttribute("noticia3_cuerpo",p.get(7));
			modelo.addAttribute("noticia3_url",p.get(8));
			//Noticia 4
			modelo.addAttribute("noticia4_encabezado",p.get(9));
			modelo.addAttribute("noticia4_cuerpo",p.get(10));
			modelo.addAttribute("noticia4_url",p.get(11));
			//Noticia 5
			modelo.addAttribute("noticia5_encabezado",p.get(12));
			modelo.addAttribute("noticia5_cuerpo",p.get(13));
			modelo.addAttribute("noticia5_url",p.get(14));
			
			return "index";
			}
	
}
