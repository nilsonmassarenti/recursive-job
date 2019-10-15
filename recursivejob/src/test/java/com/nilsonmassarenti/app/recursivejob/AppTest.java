package com.nilsonmassarenti.app.recursivejob;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.Test;

import com.nilsonmassarenti.app.recursivejob.model.Job;

public class AppTest {

	@Test
	public void testGetJobTime() {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("test1.txt").getFile());
		List<Job> jobs = App.readFile(file.getAbsolutePath());
		Job currJob = jobs.stream().filter(j -> j.getId() == 1).findFirst().get();
		int sum = App.getJobTime(0, jobs, currJob);
		assertEquals(120, sum);
		Job currJob2 = jobs.stream().filter(j -> j.getId() == 2).findFirst().get();
		sum = App.getJobTime(0, jobs, currJob2);
		assertEquals(30, sum);
		Job currJob3 = jobs.stream().filter(j -> j.getId() == 4).findFirst().get();
		sum = App.getJobTime(0, jobs, currJob3);
		assertEquals(60, sum);
	}

	@Test
	public void testReadFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("test1.txt").getFile());
		List<Job> jobs = App.readFile(file.getAbsolutePath());
		assertEquals(4, jobs.size());
	}

}
