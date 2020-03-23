package com.vihaans.core.config;

import java.io.File;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource("classpath:application.properties")
public class FileConfig {
	
	@Value("${filestore.location}")
	private String fileStore;

    @Value("${filestore.location.form5000sm.template}")
	private String editableform5000sm;

    
   public String getEditableform5000sm() {
		return editableform5000sm;
	}


public String getFolder(String companyCode, String module){
	
	String path = fileStore+companyCode+"\\"+module+"\\";
	File file = new File(path);
	if (!file.exists()){
		file.mkdirs();
	}
	
	return path;
}


public boolean createBaseFolder(String companyCode, String module){
	File file = new File(fileStore+companyCode+"\\"+module+"\\");
	file.mkdirs();
	return true;
}

}