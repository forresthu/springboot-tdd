# Tools and Libraries
## @WebMvcTest for controller unit test
Test controller without start full Spring context. 

```Java
@WebMvcTest(controllers = RegisterRestController.class)
class RegisterRestControllerTest {
  @Autowired
  private MockMvc mockMvc;
  
  @Test
  void whenValidInput_thenReturns200() throws Exception {
    mockMvc.perform(post("/forums/{forumId}/register", 42L)
        .contentType("application/json")
        .param("sendWelcomeMail", "true")
        .content(objectMapper.writeValueAsString(user)))
        .andExpect(status().isOk());

```

## @SpringBootTest for integration test

## Lombok
**@RequiredArgsConstructor**. Don't use field injection (@Autowire), use constructor injection instead. The @RequiredArgsConstructor annotation helps to reduce boilerplate code

## Mockitio
It provides ways to create a mocked class. 

```Java
# Method one
private UserRepository userRepository = Mockito.mock(UserRepository.class);

# Method two
when(userRepository.save(any(User.class))).then(returnsFirstArg());

# Method three - Use MockitoExtension
@ExtendWith(MockitoExtension.class)
class RegisterUseCaseTest {

  @Mock
  private UserRepository userRepository;
  
  @InjectMocks
  private RegisterUseCase registerUseCase;
  
  ...
}

```


## AssertJ




# Resource
[Test Driven Development with Spring Boot - YouTube](https://www.youtube.com/watch?v=s9vt6UJiHg4&t=197s)  
[Unit Testing with Spring Boot](https://reflectoring.io/unit-testing-spring-boot/)
