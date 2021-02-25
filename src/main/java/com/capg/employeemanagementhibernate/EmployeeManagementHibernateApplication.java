package com.capg.employeemanagementhibernate;

import java.util.function.Predicate;
import static springfox.documentation.builders.PathSelectors.regex;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication(scanBasePackages = "com.capg")
@EnableOpenApi
@EntityScan(basePackages = "com.capg.entity")
public class EmployeeManagementHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementHibernateApplication.class, args);
		
	}
	@Bean
	  public Docket openApiEmployee() {
	    return new Docket(DocumentationType.OAS_30)
	        .groupName("open-api-employee-store")
	        .select()
	        .paths(employeePaths())
	        .build();
	  }
	/**
	 * 
	 * @return regex
	 */

	  private Predicate<String> employeePaths() {
	    return regex(".*/api/employees/.*");
	  }

}
