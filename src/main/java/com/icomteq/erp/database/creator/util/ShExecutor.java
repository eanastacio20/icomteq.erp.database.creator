package com.icomteq.erp.database.creator.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class ShExecutor {

	private static Log log = LogFactory.getLog(ShExecutor.class);

	public void executeShellScript(List<String> parameters) throws IOException {
		ProcessBuilder pb = new ProcessBuilder(parameters);
		Process p = pb.start();
		String errStr = "";
		String str = "";
		try (InputStream is = p.getInputStream(); InputStream isErr = p.getErrorStream();) {
			str = reader(is);
			if (str != null) {
				if (!str.trim().equals("")) {
					log.info(str);
				}
			}

			errStr = reader(isErr);
			if (errStr != null) {
				if (!errStr.trim().equals("")) {
					log.warn(errStr);
					
				}
			}

			int eval = p.waitFor();
			
		} catch (Exception e) {
			log.fatal("command : {} ,exception", e);
		}
		
		if(!errStr.isEmpty() && (errStr.contains("ERROR") || errStr.contains("error"))) {
			throw new IOException(errStr);
		}
		
	}

	private String reader(InputStream input) {
		StringBuilder outDat = new StringBuilder();
		try (InputStreamReader inputReader = new InputStreamReader(input, StandardCharsets.UTF_8);
				BufferedReader bufferedReader = new BufferedReader(inputReader)) {
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				outDat.append(line);
				outDat.append("\n");
			}
		} catch (IOException e) {
			log.fatal("command : {} ,exception", e);
		}
		return outDat.toString();
	}
}
