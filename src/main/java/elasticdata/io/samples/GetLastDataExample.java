package elasticdata.io.samples;

import elasticdata.io.EsDataClient;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GetLastDataExample {

    public static void main(String[] args) {
        EsDataClient esDataClient = new EsDataClient("publicKey", "secretKey");
        try {
            String pipelineId = "5dba0500b634d2000159389a";
            List<HashMap<String, Object>> data = esDataClient.getLastData(pipelineId);
            System.out.println("docs.size() = " + data.size());
            if (!data.isEmpty()) {
                HashMap<String, Object> firstDoc = data.get(0);
                System.out.println("keys: " + Arrays.toString(firstDoc.keySet().toArray()));
            }
        } catch (Exception e) {
            System.out.println("get pipeline last data fail, more error description in Exception");
            System.out.println(e);
        }
    }
}
