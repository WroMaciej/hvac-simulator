package wromaciej.hvac_sim.features;

import com.google.gson.Gson;
import org.apache.commons.lang3.SerializationUtils;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class Copy {

    /**
     * Returns a deep copy of an object
     * @param objectToCopy
     * @return
     */
    public static Object deepCopyByGson(Object objectToCopy){
        Gson gson = new Gson();
        Object deepCopy = gson.fromJson(gson.toJson(objectToCopy), Object.class);
        return deepCopy;
    }

    public <T> T deepCopyByGsonExtended(T object, Class<T> type) {
        try {
            Gson gson = new Gson();
            return gson.fromJson(gson.toJson(object, type), type);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public <T extends Serializable> T deepCopyBySerialization(T objectToCopy){
        return SerializationUtils.clone(objectToCopy);
    }

    public <T extends Serializable> T deepCopyWithNewId(T objectToCopy){
        return SerializationUtils.clone(objectToCopy);
    }
}
