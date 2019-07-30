package com.bangbang.support;

import com.github.tomakehurst.wiremock.client.WireMock;

/**
 * @author gaoxiong@asiainfo.com
 * @date 2019-07-19 08:12
 */

public class WireMockTest {

    public static void main(String[] args) {

        WireMock.configureFor("127.0.0.1", 8080);
        WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/book"))
                .willReturn(WireMock.okJson("{'name', 'aaaa'}")));
    }
}
