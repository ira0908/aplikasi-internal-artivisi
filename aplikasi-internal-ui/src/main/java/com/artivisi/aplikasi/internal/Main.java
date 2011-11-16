package com.artivisi.aplikasi.internal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.artivisi.aplikasi.internal.MasterPegawaiService;
import com.artivisi.aplikasi.internal.entity.MasterPegawai;

public class Main {
	
	private static ApplicationContext appCtx;
	private static MasterPegawaiService service;
	
	public static void main (String[] args) {
		
        appCtx = new ClassPathXmlApplicationContext(
                "classpath:applicationContext.xml");
        service =(MasterPegawaiService) appCtx.getBean("pegawaiService");
        peg();
        

	}
	
	private static void peg(){
		
		MasterPegawai pegawai = new MasterPegawai();
		pegawai.setKodePegawai("001");
		pegawai.setNamaPegawai("test");
		pegawai.setAlamat("jakarta");
		pegawai.setNoTelp("012");
		service.savePegawai(pegawai);
	}

}
