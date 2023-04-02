package com.bolaji.countriesData.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.bolaji.countriesData.models.CountriesModel;
import com.bolaji.countriesData.models.CountryGDPModel;
import com.bolaji.countriesData.models.CountryRequest;
import com.bolaji.countriesData.models.ResponseEnum;
import com.bolaji.countriesData.models.ResponseUtils;
import com.bolaji.countriesData.utilities.CountriesUtilities;

@Service

public class CountriesRepoImpl implements CountriesRepo {
  private static Logger logger = LoggerFactory.getLogger(CountriesRepoImpl.class);

  @Value("${databasePackage}")
  private String dataBasePackage;

  @Autowired
  CountriesUtilities countriesUtilities;

  @Override
  public ResponseEntity<ResponseUtils> getAllCountries() {
    // TODO Auto-generated method stub
    Connection connection = null;
    CallableStatement callableStatement = null;
    ResultSet resultSet = null;
    ResponseUtils response = new ResponseUtils();
    CountriesModel countriesModel = null;
    List<CountriesModel> details = new ArrayList<>();

    try {
      connection = CountriesUtilities.getConnection();
      String query = "{call " + dataBasePackage + ".getAllCountries(" +
          "?," + // 1
          "?," + // 2
          "?" + // 3
          "?" + // 4
          ")}";

      callableStatement = connection.prepareCall(query);

      callableStatement.registerOutParameter(1, Types.VARCHAR);
      callableStatement.registerOutParameter(2, Types.VARCHAR);
      callableStatement.registerOutParameter(3, Types.REF_CURSOR);
      callableStatement.execute();

      logger.info("responseCode: {} ", callableStatement.getString(1));
      logger.info("responseMessage: {} ", callableStatement.getString(2));

      response.setResponseCode(callableStatement.getString(1));
      response.setResponseMessage(callableStatement.getString(2));
      resultSet = (ResultSet) callableStatement.getObject(3);

      if (response.getResponseCode().equals("000") && response.getResponseMessage().equals("Successful")) {
        while (resultSet.next()) {
          countriesModel = new CountriesModel();

          countriesModel.setRank(resultSet.getInt("country_rank"));
          countriesModel.setCountry(resultSet.getString("country_name"));
          countriesModel.setContinent(resultSet.getString("coutinent"));
          countriesModel.setPopulation(resultSet.getDouble("population"));
          countriesModel.setDependency(resultSet.getString("dependency"));
          countriesModel.setSource(resultSet.getString("source"));
          countriesModel.setDate(resultSet.getDate("data"));

          details.add(countriesModel);
        }

      }
      response.setData(details);
      // logger.info("response: {}", response);

    } catch (Exception e) {
      e.printStackTrace();
      logger.error(e.getMessage(), "error occurred while fetching record");
      response.setResponseCode("99");
      response.setResponseMessage("An error occurred while fetching transaction status");
    } finally {
      CountriesUtilities.closeConnection(connection, callableStatement, resultSet);
    }
    return  ResponseEntity.ok(response) ;

  }

  @Override
  public ResponseEntity<ResponseUtils> getCountriesByGDP(CountryRequest request) {
    // TODO Auto-generated method stub
    Connection connection = null;
    CallableStatement callableStatement = null;
    ResultSet resultSet = null;
    ResponseUtils response = new ResponseUtils();
    CountryGDPModel countryGDPModel = null;

    try {
      connection = CountriesUtilities.getConnection();
      String query = "{call " + dataBasePackage + ".getCountriesByGDP(" +
          "?," + // 1
          "?," + // 2
          "?" + // 3
          ")}";

      callableStatement = connection.prepareCall(query);
      callableStatement.setString(1, request.getCountryCode() == null ? "" : request.getCountryCode());
      callableStatement.registerOutParameter(2, Types.VARCHAR);
      callableStatement.registerOutParameter(3, Types.VARCHAR);
      callableStatement.registerOutParameter(4, Types.REF_CURSOR);
      callableStatement.execute();

      logger.info("responseCode: {} ", callableStatement.getString(1));
      logger.info("responseMessage: {} ", callableStatement.getString(2));

      response.setResponseCode(callableStatement.getString(1));
      response.setResponseMessage(callableStatement.getString(2));
      resultSet = (ResultSet) callableStatement.getObject(3);

      if (response.getResponseCode().equals("000") && response.getResponseMessage().equals("Successful")) {
        while (resultSet.next()) {
          countryGDPModel = new CountryGDPModel();

          countryGDPModel.setRank(resultSet.getString("rank"));
          countryGDPModel.setCountry(resultSet.getString("country"));
          countryGDPModel.setCountryEconomy(resultSet.getString("countryEconomy"));
          countryGDPModel.setGdpInMillions(resultSet.getString("gdpInMillions"));
          countryGDPModel.setGdpYear(resultSet.getString("dependency"));
          countryGDPModel.setAgricultureGDP(resultSet.getString("agricultureGDP"));
          countryGDPModel.setIndexNumber(resultSet.getString("indexNumber"));
          countryGDPModel.setIndustry(resultSet.getString("industry"));
          countryGDPModel.setServices(resultSet.getString("industry"));
          countryGDPModel.setYearSector(resultSet.getString(""));

        }

      }else{
        CountriesUtilities.closeConnection(connection, callableStatement, resultSet);
        response.setResponseCode(ResponseEnum.SERVICE_UNAVAILABLE.getCode());
        response.setResponseMessage(ResponseEnum.SERVICE_UNAVAILABLE.getMessage());
        return  ResponseEntity.ofNullable(response);
      }
      response.setData(countryGDPModel);
      // logger.info("response: {}", response);

    } catch (Exception e) {
      e.printStackTrace();
      logger.error(e.getMessage(), "error occurred while fetching record");
      response.setResponseCode("99");
      response.setResponseCode(ResponseEnum.SERVICE_UNAVAILABLE.getCode());
      response.setResponseMessage(ResponseEnum.SERVICE_UNAVAILABLE.getMessage());
    } finally {
      CountriesUtilities.closeConnection(connection, callableStatement, resultSet);
    }
    return  ResponseEntity.ok(response);

  }

  @Override
  public ResponseEntity<CountriesModel> getCountriesInternetUser(CountryRequest request) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getCountriesInternetUser'");
  }

}