import configuration.SessionFactoryUtil;
import entity.Driver;
import entity.TransportCompany;
import helper.QualificationEnum;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.Date;

public class TransportCompanyTest extends AbstractTest {
    public TransportCompany company;
    @Test
    void createTransportCompany(){
        company = new TransportCompany();
        company.setName("TestCompany");
        company.setDate(new Date().toString());
        company.setIncome(256.33);
        Assertions.assertEquals(0, company.getId());
        session.persist(company);
        Assertions.assertNotNull(company.getId());
    }
//    @Nested
//    class Drivers{
//        @Test
//        void createDriver(){
//            Driver driver = new Driver();
//            driver.setTransportCompany(company);
//            driver.setName("TestDriver");
//            driver.setSalary(2350);
//            driver.setQualification(QualificationEnum.A.toString());
//            Assertions.assertEquals(0, driver.getId());
//            session.persist(driver);
//            Assertions.assertNotNull(driver.getId());
//        }
//    }
}
