package com.bolaji.countriesData.repositories;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.bolaji.countriesData.models.CountriesModel;
import com.bolaji.countriesData.models.CountryRequest;
import com.bolaji.countriesData.utilities.CountriesUtilities;





@Service

public class CountriesRepoImpl  implements CountriesRepo {
    private static Logger logger = LoggerFactory.getLogger(CountriesRepoImpl.class);

    @Value("${databasePackage}")
    private String dataBasePackage;




    @Override
    public ResponseEntity<CountriesModel> getAllCountries() {
        // TODO Auto-generated method stub
        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet resultSet = null;
        CountriesModel countriesModel = null;
        //ResponseUtils response = new ResponseUtils();
        List<CountriesModel> details = new ArrayList<>();

        



        try {
           connection = CountriesUtilities.getConnection();
            String query = "{call " + dataBasePackage + ".get_transactions_by_queue_state(" +
                    "?," + // 1
                    "?," + // 2
                    "?" + // 3
                    ")}";


           callableStatement = connection.prepareCall(query);
            callableStatement.registerOutParameter(1, Types.VARCHAR);
            callableStatement.registerOutParameter(2, Types.VARCHAR);
            callableStatement.registerOutParameter(3, Types.REF_CURSOR);
            callableStatement.execute();

            logger.info("responseCode: {} ", callableStatement.getString(1));
            logger.info("responseMessage: {} ", callableStatement.getString(2));

            // // response.setResponseCode(callableStatement.getString(1));
            // // response.setResponseMessage(callableStatement.getString(2));
            // resultSet = (ResultSet) callableStatement.getObject(3);

            // if (response.getResponseCode().equals("000") && response.getResponseMessage().equals("Successful")) {
            //     while (resultSet.next()) {
            //         countriesModel = new CountriesModel();
            //         // transactionStatusDetails.setTransactionReference(resultSet.getString("TRAN_REFERENCE"));
            //         // transactionStatusDetails.setStatus(resultSet.getString("QUEUE_STATE"));
            //         // transactionStatusDetails.setCallBackUrl(resultSet.getString("CALLBACK_URL"));
            //         // transactionStatusDetails.setTransactingPartner(resultSet.getString("TRANSACTION_PARTNER"));
            //         // details.add(transactionStatusDetails);
            //     }

            // }
          //  response.setData(details);
          //  logger.info("response: {}", response);

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), "error occurred while fetching transaction");
            // response.setResponseCode("99");
            // response.setResponseMessage("An error occurred while fetching transaction status");
        } finally {
          //  dbConnection.closeConnection(connection, callableStatement, resultSet);
        }
        return null;

        
    }

    

    @Override
    public ResponseEntity<CountriesModel> getCountriesByGDP(CountryRequest request) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getCountriesByGDP'");
    }

    @Override
    public ResponseEntity<CountriesModel> getCountriesInternetUser(CountryRequest request) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getCountriesInternetUser'");
    }
    
}