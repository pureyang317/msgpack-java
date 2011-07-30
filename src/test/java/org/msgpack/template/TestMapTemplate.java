package org.msgpack.template;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.msgpack.MessagePack;
import org.msgpack.TestSet;
import org.msgpack.packer.BufferPacker;
import org.msgpack.packer.Packer;
import org.msgpack.unpacker.BufferUnpacker;
import org.msgpack.unpacker.Unpacker;


@Ignore
public class TestMapTemplate {

    @Test
    public void testPackUnpack() throws Exception {
	new TestPackUnpack().testMap();
    }

    @Test
    public void testPackBufferUnpack() throws Exception {
	new TestPackBufferUnpack().testMap();
    }

    @Test
    public void testBufferPackBufferUnpack() throws Exception {
	new TestBufferPackBufferUnpack().testMap();
    }

    @Test
    public void testBufferPackUnpack() throws Exception {
	new TestBufferPackUnpack().testMap();
    }

    private static class TestPackUnpack extends TestSet {
	@Test @Override
	public void testMap() throws Exception {
	    super.testMap();
	}

	@Override
	public <K, V> void testMap(Map<K, V> v, Class<K> keyElementClass, Class<V> valueElementClass) throws Exception {
	    MessagePack msgpack = new MessagePack();
	    Template keyElementTemplate = msgpack.lookup(keyElementClass);
	    Template valueElementTemplate = msgpack.lookup(valueElementClass);
	    Template tmpl = new MapTemplate(keyElementTemplate, valueElementTemplate);
	    ByteArrayOutputStream out = new ByteArrayOutputStream();
	    Packer packer = msgpack.createPacker(out);
	    tmpl.write(packer, v);
	    byte[] bytes = out.toByteArray();
	    Unpacker unpacker = msgpack.createUnpacker(new ByteArrayInputStream(bytes));
	    String ret = (String) tmpl.read(unpacker, null);
	    assertEquals(v, ret);
	}
    }

    private static class TestPackBufferUnpack extends TestSet {
	@Test @Override
	public void testMap() throws Exception {
	    super.testMap();
	}

	@Override
	public <K, V> void testMap(Map<K, V> v, Class<K> keyElementClass, Class<V> valueElementClass) throws Exception {
	    MessagePack msgpack = new MessagePack();
	    Template keyElementTemplate = msgpack.lookup(keyElementClass);
	    Template valueElementTemplate = msgpack.lookup(valueElementClass);
	    Template tmpl = new MapTemplate(keyElementTemplate, valueElementTemplate);
	    ByteArrayOutputStream out = new ByteArrayOutputStream();
	    Packer packer = msgpack.createPacker(out);
	    tmpl.write(packer, v);
	    byte[] bytes = out.toByteArray();
	    BufferUnpacker unpacker = msgpack.createBufferUnpacker(bytes);
	    String ret = (String) tmpl.read(unpacker, null);
	    assertEquals(v, ret);
	}
    }

    private static class TestBufferPackBufferUnpack extends TestSet {
	@Test @Override
	public void testMap() throws Exception {
	    super.testMap();
	}

	@Override
	public <K, V> void testMap(Map<K, V> v, Class<K> keyElementClass, Class<V> valueElementClass) throws Exception {
	    MessagePack msgpack = new MessagePack();
	    Template keyElementTemplate = msgpack.lookup(keyElementClass);
	    Template valueElementTemplate = msgpack.lookup(valueElementClass);
	    Template tmpl = new MapTemplate(keyElementTemplate, valueElementTemplate);
	    BufferPacker packer = msgpack.createBufferPacker();
	    tmpl.write(packer, v);
	    byte[] bytes = packer.toByteArray();
	    BufferUnpacker unpacker = msgpack.createBufferUnpacker(bytes);
	    String ret = (String) tmpl.read(unpacker, null);
	    assertEquals(v, ret);
	}
    }

    private static class TestBufferPackUnpack extends TestSet {
	@Test @Override
	public void testMap() throws Exception {
	    super.testMap();
	}

	@Override
	public <K, V> void testMap(Map<K, V> v, Class<K> keyElementClass, Class<V> valueElementClass) throws Exception {
	    MessagePack msgpack = new MessagePack();
	    Template keyElementTemplate = msgpack.lookup(keyElementClass);
	    Template valueElementTemplate = msgpack.lookup(valueElementClass);
	    Template tmpl = new MapTemplate(keyElementTemplate, valueElementTemplate);
	    BufferPacker packer = msgpack.createBufferPacker();
	    tmpl.write(packer, v);
	    byte[] bytes = packer.toByteArray();
	    Unpacker unpacker = msgpack.createUnpacker(new ByteArrayInputStream(bytes));
	    String ret = (String) tmpl.read(unpacker, null);
	    assertEquals(v, ret);
	}
    }
}
