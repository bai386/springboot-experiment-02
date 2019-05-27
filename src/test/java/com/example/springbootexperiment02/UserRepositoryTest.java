package com.example.springbootexperiment02;

import com.example.springbootexperiment02.entity.Address;
import com.example.springbootexperiment02.entity.User;
import com.example.springbootexperiment02.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    /**
     * 编写单元测试用例，测试方法实现的结果是否正确
     */
    @Test
    public void addUserTest() {
        User user = userRepository.addUser(new User("bai"));
        log.debug("{}", user.getInsertTime());
        User user1 = userRepository.addUser(new User("hei"));
        log.debug("{}", user1.getInsertTime());
    }
    @Test
    public void addAddressTest(){
        Address address=userRepository.addAddress(new Address("757"), 1);
        log.debug("{}",address.getInsertTime());
        Address address1=userRepository.addAddress(new Address("910"), 2);
        log.debug("{}",address1.getInsertTime());
    }
    @Test
    public void updateUserTest(){
        User user=userRepository.updateUser(1, "wang");
        log.debug("{}",user.getName());
    }
    @Test
    public void updateAddressTest(){
        Address address=userRepository.updateAddress(2, 1);
        log.debug("{}",address.getDetail());
    }
    @Test
    public void ListAddressesTest(){
        List<Address> list=userRepository.listAddresses(1);
        log.debug("{}",list);
    }
    @Test
    public void removeAddressTest(){
        userRepository.removeAddress(2);
    }
    @Test
    public void removeUserTest(){
        userRepository.removeUser(1);
    }
}
