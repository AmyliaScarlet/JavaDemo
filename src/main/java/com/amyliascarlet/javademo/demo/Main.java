package com.amyliascarlet.javademo.demo;

import com.amyliascarlet.javademo.elasticsearch.Elasticsearch;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Main {

	public static void main(String[] args) {
        new Elasticsearch();

	}




}

