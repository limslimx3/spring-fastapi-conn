package capstone.springflaskconn.controller;

import capstone.springflaskconn.dto.RequestDto;
import capstone.springflaskconn.dto.ResponseDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class TestController {

    @GetMapping("/get/{data}")
    public Mono<String> getTest(@PathVariable("data") String data) {
        WebClient webClient = WebClient.builder()
                .baseUrl("http://localhost:8000")
                .build();

        Mono<String> response = webClient.get()
                .uri("/api/get/" + data)
                .retrieve()
                .bodyToMono(String.class);
        return response;
    }

    @PostMapping("/post")
    public ResponseDto postTest(@RequestBody RequestDto requestDto) {
        WebClient webClient = WebClient.builder()
                .baseUrl("http://localhost:8000")
                .build();

        return webClient.post()
                .uri("/api/post")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(requestDto)
                .retrieve()
                .bodyToMono(ResponseDto.class)
                .block();
    }
}
