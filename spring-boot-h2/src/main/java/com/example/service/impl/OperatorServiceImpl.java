package com.example.service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.example.entity.Operators;
import com.example.repository.OperatorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.Operator;
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
	public List<Operators> getAllOperators() {
		return operatorRepository.findAll();
	}

	@Override
	public Operators getOperator(Long operatorId) {
		Optional<Operators> optOperator = operatorRepository.findById(operatorId);
		return optOperator.get();
	}

	@Override
	public Operators saveOperator(Operators operator) {
		return operatorRepository.save(operator);
	}

	@Override
	public void deleteEmployee(Long operatorId) {
		operatorRepository.deleteById(operatorId);
	}

	@Override
	public Operators updateEmployee(Operators operators) {
		return operatorRepository.save(operators);
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
						"airtel.india@airtel.com",
						"https://pbs.twimg.com/profile_images/644805995705692160/hByAwFLY_400x400.png", "url"),
				new Operators("vodafone", "120", "5", "10Mbps", "Airtel India Wiki Page Informations", "+910910910901",
						"airtel.india@airtel.com",
						"https://akm-img-a-in.tosshub.com/indiatoday/images/story/201701/vodafonelogo-559_010617085418.jpg",
						"url"),
				new Operators("reliance jio", "120", "5", "10Mbps", "Airtel India Wiki Page Informations", "+910910910901",
						"airtel.india@airtel.com",
						"https://upload.wikimedia.org/wikipedia/commons/thumb/d/df/TOSHIBA_Logo.png/320px-TOSHIBA_Logo.png",
						"url"));

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
