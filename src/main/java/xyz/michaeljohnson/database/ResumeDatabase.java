package xyz.michaeljohnson.database;

import java.lang.reflect.Field;

import com.google.common.collect.ImmutableMap;

import lombok.Getter;
import xyz.michaeljohnson.content.ResumeContent;

public class ResumeDatabase {
	
	@Getter
	private static ImmutableMap<String, String> resumeData;
	
	static {
		
		ImmutableMap.Builder<String, String> builder = ImmutableMap.builder();
		
		for(Field f: ResumeContent.class.getFields()) {
			try {
				builder.put(f.getName(), f.get(f).toString());
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		resumeData = builder.build();
		
		
	}

}
