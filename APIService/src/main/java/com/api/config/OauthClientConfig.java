package com.api.config;

/**
 * Created by Martha on 3/19/2017.
 */
//@Configuration
public class OauthClientConfig {
//
//    @Autowired(required = false)
//    ClientHttpRequestFactory clientHttpRequestFactory;
//
//    private ClientHttpRequestFactory getClientHttpRequestFactory() {
//        if (clientHttpRequestFactory == null) {
//            clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
//        }
//        return clientHttpRequestFactory;
//    }
//
//    @LoadBalanced
//    @Bean
//    @Qualifier("myRestTemplate")
//    public OAuth2RestOperations restTemplate() {
//
//        OAuth2RestTemplate template = new OAuth2RestTemplate(
//                fullAccessresourceDetails(),
//                new DefaultOAuth2ClientContext(
//                new DefaultAccessTokenRequest()));
//        return prepareTemplate(template, false);
//    }
//
//    @LoadBalanced
//    @Bean
//    @Qualifier("myClientOnlyRestTemplate")
//    public OAuth2RestOperations restClientOnlyTemplate() {
//
//        OAuth2RestTemplate template = new OAuth2RestTemplate(
//                fullAccessresourceDetailsClientOnly(),
//                new DefaultOAuth2ClientContext(
//                new DefaultAccessTokenRequest()));
//        return prepareTemplate(template, true);
//    }
//
//    public OAuth2RestTemplate prepareTemplate(OAuth2RestTemplate template, boolean isClient) {
//        template.setRequestFactory(getClientHttpRequestFactory());
//        if (isClient) {
//            template.setAccessTokenProvider(clientAccessTokenProvider());
//        } else {
//            template.setAccessTokenProvider(userAccessTokenProvider());
//        }
//        return template;
//    }
//
//    @Bean
//    public AccessTokenProvider userAccessTokenProvider() {
//        ResourceOwnerPasswordAccessTokenProvider accessTokenProvider = new ResourceOwnerPasswordAccessTokenProvider();
//        accessTokenProvider.setRequestFactory(getClientHttpRequestFactory());
//        return accessTokenProvider;
//    }
//
//    @Bean
//    public AccessTokenProvider clientAccessTokenProvider() {
//        ClientCredentialsAccessTokenProvider accessTokenProvider = new ClientCredentialsAccessTokenProvider();
//        accessTokenProvider.setRequestFactory(getClientHttpRequestFactory());
//        return accessTokenProvider;
//    }
//
//    @Bean
//    @Qualifier("myFullAcessDetails")
//    public OAuth2ProtectedResourceDetails fullAccessresourceDetails() {
//        ResourceOwnerPasswordResourceDetails resource = new ResourceOwnerPasswordResourceDetails();
//        List<String> scopes = new ArrayList<>(1);
//        scopes.add("WEB");
//        resource.setAccessTokenUri("http://localhost:1110/auth/oauth/token");
//        resource.setClientId("web_app");
//        resource.setClientSecret("pass");
//        resource.setGrantType("password");
//        resource.setScope(scopes);
//        resource.setUsername("**USERNAME**");
//        resource.setPassword("**PASSWORD**");
//
//        return resource;
//    }
//
//    @Bean
//    @Qualifier("myClientOnlyFullAcessDetails")
//    public OAuth2ProtectedResourceDetails fullAccessresourceDetailsClientOnly() {
//        ResourceOwnerPasswordResourceDetails resource = new ResourceOwnerPasswordResourceDetails();
//        List<String> scopes = new ArrayList<>(1);
//        scopes.add("WEB");
//        resource.setAccessTokenUri("http://localhost:1110/auth/oauth/token");
//        resource.setClientId("web_app");
//        resource.setClientSecret("pass");
//        resource.setGrantType("password");
//        resource.setScope(scopes);
//        resource.setUsername("**USERNAME**");
//        resource.setPassword("**PASSWORD**");
//
//        return resource;
//    }
}
