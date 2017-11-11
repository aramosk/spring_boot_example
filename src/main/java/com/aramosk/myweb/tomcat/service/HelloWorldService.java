/*
 * Copyright 2012-2013 the original author or authors.
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

package com.aramosk.myweb.tomcat.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldService {

	@Value("${name:World}")
	private String name;
        
        public static void print(String word) {
            System.out.println("Printing " + word);
        }

	public String getHelloMessage() {
                String[] myList = {"Alfredo", "Daniel", "Ramos", "Kustron"};
                
                List<String> list = Arrays.asList(myList);
                list.stream().filter(word -> word.startsWith("o")).forEach(System.out::println);
                
                list.stream().forEach(HelloWorldService::print);
                
                List<String> list2 = list.stream().sorted().collect(Collectors.toList());
                
		return "Hello " + this.name + ": " + Arrays.toString(list2.toArray());
	}

}
