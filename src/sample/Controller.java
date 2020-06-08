package sample;

import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sample.config.NetworkService;
import sample.model.BearerToken;
import sample.model.User;

public class Controller {

    @FXML
    private TextField loginField;

    @FXML
    private TextField passwordField;

    @FXML
    private Label errorMessage;

    private int responseCode;

    private BearerToken bearerToken;

    public void generateNumber(ActionEvent actionEvent) {

        User user = new User();
        user.setUsername(loginField.getText());
        user.setPassword(passwordField.getText());

        NetworkService.getInstance()
                .getJSONApi()
                .loginByPassword(user)
                .enqueue(new Callback<BearerToken>() {
                    @Override
                    public void onResponse(Call<BearerToken> call, Response<BearerToken> response) {
                        if (response.code() == 200) {
                            responseCode = 200;
                            bearerToken = response.body();
                        }
                    }
                    @Override
                    public void onFailure(Call<BearerToken> call, Throwable throwable) {
                        System.out.println("screw you");
                    }
                });
        if (responseCode != 200) {
            errorMessage.setVisible(true);
            errorMessage.setText("Login or password are incorrect");
        } else {
            errorMessage.setVisible(false);
        }


    }


}
