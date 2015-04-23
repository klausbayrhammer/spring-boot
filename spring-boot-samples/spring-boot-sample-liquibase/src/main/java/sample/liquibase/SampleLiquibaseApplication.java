/*
 * Copyright 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample.liquibase;

import static org.mockito.Mockito.mock;

import javax.sql.DataSource;

import liquibase.integration.spring.SpringLiquibase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SampleLiquibaseApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SampleLiquibaseApplication.class, args);
	}

    @Bean
    public SpringLiquibase getLiquibaseBean() {
        SpringLiquibase springLiquibase = new SpringLiquibase();
        springLiquibase.setDataSource(mock(DataSource.class));
        springLiquibase.setChangeLog("classpath:db/changelog/db.changelog-master.yaml");
        return springLiquibase;
    }
}
