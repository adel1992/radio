package com.stream.radio;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StreamController {

	@GetMapping("/getStreaming")
	void getStreaming(HttpServletResponse response) throws MalformedURLException, IOException{
		response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
		IOUtils.copy(RadioConnector.getRadioStream("http://radio.mosaiquefm.net:8000/mosalive"), response.getOutputStream());
	}
	
}
