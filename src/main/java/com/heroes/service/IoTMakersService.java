package com.heroes.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.heroes.repository.StatisticsDao;

@Service
public class IoTMakersService {

  @Autowired
  private StatisticsDao statisticsDao;

  public static String token = null;
  RestTemplate restTemplate = new RestTemplate();

  public int test() {



    useGetRestTemplete("https://iotmakers.kt.com:443/api/v1/streams/zone1/log?period=9999&from=1544108400000&count=9999");

    return 0;
  }


  public void useGetRestTemplete(String url) {

    HttpHeaders header = new HttpHeaders();
    header.add(HttpHeaders.AUTHORIZATION,
        "Bearer eyJhbGciOiJSUzI1NiJ9.eyJzdmNfdGd0X3NlcSI6IjEwMDAwMDY2NTQiLCJ1c2VyX25hbWUiOiJ0a2RnanMxNTAxIiwicHViX3RpbWUiOjE1NDQxNzg0ODMxNjQsIm1icl9pZCI6InRrZGdqczE1MDEiLCJtYnJfc2VxIjoiMTAwMDAwNjUzNyIsIm1icl9jbGFzIjoiMDAwMyIsImF1dGhvcml0aWVzIjpbIlJPTEVfT1BFTkFQSSIsIlJPTEVfVVNFUiJdLCJwbGF0Zm9ybSI6IjNNUCIsInRoZW1lX2NkIjoiUFRMIiwiY2xpZW50X2lkIjoiMmlvSWtHWDFmYzQwUDhiTyIsImF1ZCI6WyJJT1QtQVBJIl0sInVuaXRfc3ZjX2NkIjoiMDAxIiwic2NvcGUiOlsidHJ1c3QiXSwiZHN0cl9jZCI6IjAwMSIsImNvbXBhbnkiOiJLdCIsIm1icl9ubSI6Iuq5gOyDge2XjCIsImV4cCI6MTU0NDc3ODQ4MywianRpIjoiYTJmNDhhNGEtYWFiNy00YTllLWFlNTUtYTcyYmNlMWE0ZWU5In0.mL4LAZTV0JWA3ocyi5pmnsR8UERKlUre18skTSA2kZmP3Lk_8pNRQGPIx4D-whB4PyqW65xxql2C2A1n42C-urKUpCi461jn2wiUoO43GkpzHAP7sIvXxkZMg3JCsXt62Bc7d6rfLaQ8eckXHeJwewajLuipTwLgfQIpx3yvcKMEzYvCXYc69J6jb0VT1qMgGcOtlpsw87N0MgxoytIsuai28xjL_PNQABJqRYm2m2xcm4pi-sqQUHaBTib6Be6DNTJLy4K5_hITsNbf1wKu-4OmO9xH0nc6Hx1Xr3Y84bBt-4uFvdk5pycAj1QJyx8-b207ACixLWFTo553BbYa0Q");

    ResponseEntity<String> response = new RestTemplate().exchange(url, HttpMethod.GET, new HttpEntity(header), String.class);
    ObjectMapper mapper = new ObjectMapper();
    Map<Object, Object> map = new HashMap<Object, Object>();

    try {
      map = mapper.readValue(response.getBody(), new TypeReference<Map<Object, Object>>() {});
    } catch (JsonParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (JsonMappingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }


    ArrayList<Object> data = (ArrayList<Object>) map.get("data");

    
    
    System.out.println(map + "aaaaaaaaaaaaaaaa");
  }

}
