/**
 *    Copyright 2009-2020 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.mybatis.guice.environment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.transaction.TransactionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EnvironmentProviderTest {
  private EnvironmentProvider environmentProvider;
  private String id;
  @Mock
  private DataSource dataSource;
  @Mock
  private TransactionFactory transactionFactory;

  @BeforeEach
  public void beforeTest() {
    environmentProvider = new EnvironmentProvider();
    id = "test environment";
    environmentProvider.setId(id);
    environmentProvider.setDataSource(dataSource);
    environmentProvider.setTransactionFactory(transactionFactory);
  }

  @Test
  public void get() {
    Environment environment = environmentProvider.get();
    assertEquals(id, environment.getId());
    assertEquals(dataSource, environment.getDataSource());
    assertEquals(transactionFactory, environment.getTransactionFactory());
  }
}
