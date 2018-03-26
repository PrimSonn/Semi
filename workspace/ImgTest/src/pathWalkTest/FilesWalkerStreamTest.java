package pathWalkTest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Stack;
import java.util.stream.Stream;

public class FilesWalkerStreamTest {

	public static void main(String[] args) {
		
		/*
		File[] files = new File("./").listFiles();
		Stack<File> stack = new Stack<File>();
		File file;
		
		for(File f : files) {
			System.out.println("toString: "+ f);
			System.out.println("Absolute: "+ f.getAbsolutePath());
		}
		*/
		
		
		/*
		for(File f:files) {
//			if(file.isFile())System.out.println(file);
			stack.push(f);
		}
		
		file = stack.pop();
		if(file.isFile()) {
			
		}else {
			
		}
		*/
		
		
			//----------this wont work on servlet.------------
		try (Stream<Path> paths = Files.walk(Paths.get("./"))) {
			paths.filter(path->path.toFile().isFile()).forEach(System.out::println);
			System.out.println("----------------");
		    paths.forEach(System.out::println);
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		
	}

}
