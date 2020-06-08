package sample.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zh.turemuratov on 5/22/20
 */
@Getter
@Setter
public class BearerToken {

    @SerializedName("id_token")
    private String bearerToken;

}
