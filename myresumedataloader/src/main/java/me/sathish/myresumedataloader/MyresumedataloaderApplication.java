package me.sathish.myresumedataloader;

import me.sathish.myresumedataloader.config.InitDataBean;
import me.sathish.myresumedataloader.repos.ResumeUserEducationRepo;
import me.sathish.myresumedataloader.repos.ResumeUserJobRepo;
import me.sathish.myresumedataloader.repos.ResumeUserProfileRepo;
import me.sathish.myresumedataloader.repos.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

@SpringBootApplication
public class MyresumedataloaderApplication implements CommandLineRunner {
    private static final Logger LOG = LoggerFactory
            .getLogger(MyresumedataloaderApplication.class);
    final ResumeUserProfileRepo userProfileRepository;
    final UserRepository userRepository;
    final ResumeUserJobRepo resumeUserJobRepo;
    final ResumeUserEducationRepo resumeUserEducationRepo;
    final InitDataBean initDataBean;
    final DataSource dataSource;

    public MyresumedataloaderApplication(ResumeUserProfileRepo userProfileRepository, UserRepository userRepository,
                                         ResumeUserJobRepo resumeUserJobRepo, ResumeUserEducationRepo resumeUserEducationRepo,
                                         InitDataBean initDataBean, DataSource dataSource) {
        this.userProfileRepository = userProfileRepository;
        this.userRepository = userRepository;
        this.resumeUserJobRepo = resumeUserJobRepo;
        this.resumeUserEducationRepo = resumeUserEducationRepo;
        this.initDataBean = initDataBean;
        this.dataSource = dataSource;
    }

    public static void main(String[] args) {
        LOG.info("STARTING THE APPLICATION");
        SpringApplication.run(MyresumedataloaderApplication.class, args);
        LOG.info("APPLICATION FINISHED");
    }

    @Override
    public void run(String... args) throws Exception {
        initDataBean.rootHello();
    }
}
