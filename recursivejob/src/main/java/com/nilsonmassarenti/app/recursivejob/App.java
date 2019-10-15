package com.nilsonmassarenti.app.recursivejob;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.nilsonmassarenti.app.recursivejob.model.Job;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Integer id = Integer.parseInt(args[0]);
    	Integer sum = 0;
    	List<Job> jobs = readFile(args[1]);
    	jobs.sort((j1, j2) -> j1.getId() - j2.getId());
    	Job currJob = jobs.stream().filter(j -> j.getId() == id).findFirst().get();
    	if (currJob != null) {
			sum = getJobTime(sum, jobs, currJob);
		}
    	System.out.println(sum);
    }
    
    static Integer getJobTime(Integer sum, List<Job> jobs, Job job) {
    	if (job.getChildJobIDs().length > 0) {
			for (Integer i = 0; i < job.getChildJobIDs().length; i++) {
				Integer pos = i;
				sum = getJobTime(sum, jobs, jobs.stream().filter(j-> j.getId() == job.getChildJobIDs()[pos]).findFirst().get());
				
			}
		}
    	return sum + job.getJobTime();
    }
    
    static List<Job> readFile(String path) {	
    	List<Job> jobs = new ArrayList<>();
    	try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line;
			while ((line = br.readLine()) != null) {
				int[] array = Arrays.asList(line.split(",")).stream().mapToInt(Integer::parseInt).toArray();
				int[] childJobIDs = {};
				if (array.length > 2) {
					childJobIDs = Arrays.copyOfRange(array, 2, array.length);
				}
				jobs.add(new Job(array[0], array[1], childJobIDs));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
    	return jobs;
    }
}

