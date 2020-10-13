package poc.transformer.csv.function;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Objects;
import java.util.function.Consumer;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class CSVWriter implements Consumer<String>, AutoCloseable{
	private BufferedWriter outStream;
	public CSVWriter(Path csvPath) throws IOException {
		this.outStream = Files.newBufferedWriter(csvPath, StandardOpenOption.CREATE);
		log.info("Initialized to write at : {}", csvPath.toString());
	}
	public void accept(String line) {
		try {
			outStream.write(line);
			outStream.newLine();
		} catch (IOException e) {
			log.error("Exception Occured in wiriting line : {}", line);
			e.printStackTrace();
		}
		
	}
	public void close() throws Exception {
		if(Objects.nonNull(outStream)) {
			outStream.flush();
			outStream.close();
		}
		log.info("CSV Write Closed");
	}
	
	
	
}
