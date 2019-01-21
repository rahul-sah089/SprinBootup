package com.example.service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.List;

import com.example.entity.Operators;
import com.example.repository.OperatorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperatorServiceImpl implements OperatorService {
	@Autowired
	private OperatorRepository operatorRepository;

	@Override
	public void initCSV() {
		writeCSV();
		readCSV();
	}

	@Override
	public List<Operators> getAllOperators(){
		return operatorRepository.findAll();
	}



	private void readCSV() {
		String line = "";
		Integer indexName = 0;
		Integer indexLowestPrice = 1;
		Integer indexRating = 2;
		Integer indexMaxSpeed = 3;
		Integer indexDescription = 4;
		Integer indexContactNo = 5;
		Integer indexEmail = 6;
		Integer indexImage = 7;
		Integer indexUrl = 8;
		try {
			BufferedReader fileReader = new BufferedReader(new FileReader("operators.csv"));
			fileReader.readLine();
			while ((line = fileReader.readLine()) != null) {
				System.out.println(line);
				String[] token = line.split(",");
				Operators operators = new Operators(token[indexName], token[indexLowestPrice], token[indexRating],
						token[indexMaxSpeed], token[indexDescription], token[indexContactNo], token[indexEmail],
						token[indexImage], token[indexUrl]);
				operatorRepository.save(operators);
				
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void writeCSV() {
		String csvheader = "name,lowest_price,rating,max_speed,description,contact_no,email,image,url";
		// String name, String lowestPrice, Integer rating, Float maxSpeed, String
		// description,
		// String contactNo, String email, String image, String url
		List<Operators> operators = Arrays.asList(
				new Operators("airtel", "120", "5", "10Mbps", "Airtel India Wiki Page Informations", "+910910910901",
						"airtel.india@airtel.com", "image", "url"),
				new Operators("airtel", "120", "5", "10Mbps", "Airtel India Wiki Page Informations", "+910910910901",
						"airtel.india@airtel.com", "image", "url"),
				new Operators("airtel", "120", "5", "10Mbps", "Airtel India Wiki Page Informations", "+910910910901",
						"airtel.india@airtel.com", "image", "url"),
				new Operators("airtel", "120", "5", "10Mbps", "Airtel India Wiki Page Informations", "+910910910901",
						"airtel.india@airtel.com", "image", "url"),
				new Operators("airtel", "120", "5", "10Mbps", "Airtel India Wiki Page Informations", "+910910910901",
						"airtel.india@airtel.com", "image", "url"));

		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter("operators.csv");
			fileWriter.append(csvheader);
			fileWriter.append("\n");

			for (Operators operator : operators) {
				fileWriter.append(operator.getName());
				fileWriter.append(",");

				fileWriter.append(operator.getLowestPrice());
				fileWriter.append(",");

				fileWriter.append(operator.getRating());
				fileWriter.append(",");

				fileWriter.append(operator.getMaxSpeed());
				fileWriter.append(",");

				fileWriter.append(operator.getDescription());
				fileWriter.append(",");

				fileWriter.append(operator.getContactNo());
				fileWriter.append(",");

				fileWriter.append(operator.getEmail());
				fileWriter.append(",");

				fileWriter.append(operator.getImage());
				fileWriter.append(",");

				fileWriter.append(operator.getUrl());
				fileWriter.append("\n");

			}
			System.out.println("Write CSV succesful!!");

		} catch (Exception ex) {
			System.out.println("Error while writing the CSV");
			ex.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (Exception exception) {
				System.out.println("Flushing/closing error");
				exception.printStackTrace();
			}

		}

	}

}
