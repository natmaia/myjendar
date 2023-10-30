package br.com.fiap.myjendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@SpringBootApplication
public class MyjendarApplication implements WebMvcConfigurer {

	private LocaleChangeInterceptor interceptor;

	public MyjendarApplication(final LocaleChangeInterceptor interceptor){
		this.interceptor = interceptor;
	}
	public static void main(String[] args) {
		SpringApplication.run(MyjendarApplication.class, args);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor);
		//WebMvcConfigurer.super.addInterceptors(registry);
	}

	

}
