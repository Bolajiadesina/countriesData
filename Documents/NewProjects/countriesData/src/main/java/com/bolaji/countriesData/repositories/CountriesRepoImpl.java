package com.bolaji.countriesData.repositories;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.bolaji.countriesData.models.CountriesModel;



@Service
public class CountriesRepoImpl  implements CountriesRepo {
    private static Logger logger = LoggerFactory.getLogger(CountriesRepoImpl.class);
    @Override
    public ResponseEntity<CountriesModel> getAllCountries() {
        // TODO Auto-generated method stub
        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet resultSet = null;
        CountriesModel countriesModel = null;
        ResponseUtils response = new ResponseUtils();
        List<CountriesModel> details = new ArrayList<>();

        



        try {
            connection = dbConnection.connectRTDB();
            String query = "{call " + dataBasePackage + ".get_transactions_by_queue_state(" +
                    "?," + // 1
                    "?," + // 2
                    "?" + // 3
                    ")}";


            callableStatement = connection.prepareCall(query);
            callableStatement.registerOutParameter(1, OracleTypes.VARCHAR);
            callableStatement.registerOutParameter(2, OracleTypes.VARCHAR);
            callableStatement.registerOutParameter(3, OracleTypes.CURSOR);
            callableStatement.execute();

            logger.info("responseCode: {} ", callableStatement.getString(1));
            logger.info("responseMessage: {} ", callableStatement.getString(2));

            response.setResponseCode(callableStatement.getString(1));
            response.setResponseMessage(callableStatement.getString(2));
            resultSet = (ResultSet) callableStatement.getObject(3);

            if (response.getResponseCode().equals("000") && response.getResponseMessage().equals("Successful")) {
                while (resultSet.next()) {
                    transactionStatusDetails = new TransactionStatusDetails();
                    transactionStatusDetails.setTransactionReference(resultSet.getString("TRAN_REFERENCE"));
                    transactionStatusDetails.setStatus(resultSet.getString("QUEUE_STATE"));
                    transactionStatusDetails.setCallBackUrl(resultSet.getString("CALLBACK_URL"));
                    transactionStatusDetails.setTransactingPartner(resultSet.getString("TRANSACTION_PARTNER"));
                    details.add(transactionStatusDetails);
                }

            }
            response.setData(details);
            logger.info("response: {}", response);

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), "error occurred while fetching transaction");
            response.setResponseCode("99");
            response.setResponseMessage("An error occurred while fetching transaction status");
        } finally {
            dbConnection.closeConnection(connection, callableStatement, resultSet);
        }
        return response;

        
    }

    @Override
    public CountriesModel getCountriesByGdpComposition(String gdpComposition) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCountriesByGdpComposition'");
    }

    @Override
    public CountriesModel getCountriesByNumOfInternetUser() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCountriesByNumOfInternetUser'");
    }
    
}