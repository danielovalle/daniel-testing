package org.testing;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PhraseBuilder {

	private Logger logger = LoggerFactory.getLogger(PhraseBuilder.class);
	private Map<String, String> templates;

	public String buildPhrase(String id, Object... args) {
		return MessageFormat.format(templates.get(id), args);
	}

	@PostConstruct
	public void initialize() {
		logger.info("@PostConstruct");
		templates = new HashMap<String, String>();
		templates.put("hello", "Hello, {0}!");
	}
}
