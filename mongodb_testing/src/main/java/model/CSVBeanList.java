package model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

public class CSVBeanList<T> {

	private CSVReader beanReader;
	private List<T> list;
	private ColumnPositionMappingStrategy<T> columns = new ColumnPositionMappingStrategy<T>();
	private CsvToBean<T> csv = new CsvToBean<T>();
	private Logger log = LoggerFactory.getLogger(CSVBeanList.class);

	public CSVBeanList(Class<T> type, String file) {
		super();
		list = new ArrayList<T>(0);
		try {
			beanReader = new CSVReader(new FileReader(file));
			columns.setType(type);

			// get columns names from reader and moves reader to next position.
			String[] fields = getHeaders(beanReader);

			if (fields.length != 0) {
				columns.setColumnMapping(fields);
				list = csv.parse(columns, beanReader);
			}
		} catch (FileNotFoundException e) {
			log.error(e.getMessage());
		}
	}

	/**
	 * 
	 * @param reader
	 * @return
	 */
	private String[] getHeaders(CSVReader reader) {

		String[] headers = {};
		try {

			headers = reader.readNext();
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		return headers;
	}

	public List<T> getBeans() {
		return list;
	}

}
