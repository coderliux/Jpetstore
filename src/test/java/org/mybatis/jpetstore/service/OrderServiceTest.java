package org.mybatis.jpetstore.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mybatis.jpetstore.domain.Item;
import org.mybatis.jpetstore.domain.LineItem;
import org.mybatis.jpetstore.domain.Order;
import org.mybatis.jpetstore.persistence.ItemMapper;
import org.mybatis.jpetstore.persistence.LineItemMapper;
import org.mybatis.jpetstore.persistence.OrderMapper;
import org.mybatis.jpetstore.persistence.SequenceMapper;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {

  @Mock
  private ItemMapper itemMapper;
  @Mock
  private OrderMapper orderMapper;
  @Mock
  private SequenceMapper sequenceMapper;
  @Mock
  private LineItemMapper lineItemMapper;

  @InjectMocks
  private OrderService orderService;

  @Before
  public void setUp() throws Exception {

  }

  @Test
  public void shouldReturnOrderWhenGivenOrderIdWithOutLineItems() {
    //given
    int orderId = 1;
    Order order = new Order();
    List<LineItem> lineItems = new ArrayList<LineItem>();

    //when
    when(orderMapper.getOrder(orderId)).thenReturn(order);
    when(lineItemMapper.getLineItemsByOrderId(orderId)).thenReturn(lineItems);

    //then
    assertThat(orderService.getOrder(orderId), is(order));
    assertThat(orderService.getOrder(orderId).getLineItems().size(), is(0));
  }

  @Test
  public void shouldReturnOrderWhenGivenOrderIdExistedLineItems() {
    //given
    int orderId = 1;
    Order order = new Order();
    List<LineItem> lineItems = new ArrayList<LineItem>();
    LineItem item = new LineItem();
    String itemId = "abc";
    item.setItemId(itemId);
    lineItems.add(item);

    //when
    when(orderMapper.getOrder(orderId)).thenReturn(order);
    when(lineItemMapper.getLineItemsByOrderId(orderId)).thenReturn(lineItems);
    when(itemMapper.getItem(itemId)).thenReturn(new Item());
    when(itemMapper.getInventoryQuantity(itemId)).thenReturn(new Integer(5));

    //then
    Order expectedOrder = orderService.getOrder(orderId);
    assertThat(expectedOrder, is(order));
    assertThat(expectedOrder.getLineItems().size(), is(1));
    assertThat(expectedOrder.getLineItems().get(0).getItem().getQuantity(), is(5));
  }
}