package com.rhels.ci.jenkins_api;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.Job;
import com.offbytwo.jenkins.model.JobWithDetails;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        try {
            JenkinsServer jenkins = new JenkinsServer(new URI("https://ci-rhels.rhcloud.com"), "rhels", "123");
			Map<String, Job> jobs = jenkins.getJobs();
			for (Job job1 : jobs.values()){
				System.out.println("App.main()"+job1.getName());
				JobWithDetails job = job1.details();
				System.out.println("App.main()"+job.getDisplayName());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
