package org.msgpack.template;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.junit.Test;
import org.msgpack.MessagePack;
import org.msgpack.TestSet;
import org.msgpack.packer.BufferPacker;
import org.msgpack.packer.Packer;
import org.msgpack.unpacker.BufferUnpacker;
import org.msgpack.unpacker.Unpacker;


public class TestStringTemplate {

    @Test
    public void testPackUnpack() throws Exception {
	new TestPackUnpack().testString();
    }

    @Test
    public void testPackBufferUnpack() throws Exception {
	new TestPackBufferUnpack().testString();
    }

    @Test
    public void testBufferPackBufferUnpack() throws Exception {
	new TestBufferPackBufferUnpack().testString();
    }

    @Test
    public void testBufferPackUnpack() throws Exception {
	new TestBufferPackUnpack().testString();
    }

    private static class TestPackUnpack extends TestSet {
	@Test @Override
	public void testString() throws Exception {
	    super.testString();
	}

	@Override
	public void testString(String v) throws Exception {
	    MessagePack msgpack = new MessagePack();
	    Template<String> tmpl = StringTemplate.instance;
	    ByteArrayOutputStream out = new ByteArrayOutputStream();
	    Packer packer = msgpack.createPacker(out);
	    tmpl.write(packer, v);
	    byte[] bytes = out.toByteArray();
	    Unpacker unpacker = msgpack.createUnpacker(new ByteArrayInputStream(bytes));
	    String ret = tmpl.read(unpacker, null);
	    assertEquals(v, ret);
	}
    }

    private static class TestPackBufferUnpack extends TestSet {
	@Test @Override
	public void testString() throws Exception {
	    super.testString();
	}

	@Override
	public void testString(String v) throws Exception {
	    MessagePack msgpack = new MessagePack();
	    Template<String> tmpl = StringTemplate.instance;
	    ByteArrayOutputStream out = new ByteArrayOutputStream();
	    Packer packer = msgpack.createPacker(out);
	    tmpl.write(packer, v);
	    byte[] bytes = out.toByteArray();
	    BufferUnpacker unpacker = msgpack.createBufferUnpacker(bytes);
	    String ret = tmpl.read(unpacker, null);
	    assertEquals(v, ret);
	}
    }

    private static class TestBufferPackBufferUnpack extends TestSet {
	@Test @Override
	public void testString() throws Exception {
	    super.testString();
	}

	@Override
	public void testString(String v) throws Exception {
	    MessagePack msgpack = new MessagePack();
	    Template<String> tmpl = StringTemplate.instance;
	    BufferPacker packer = msgpack.createBufferPacker();
	    tmpl.write(packer, v);
	    byte[] bytes = packer.toByteArray();
	    BufferUnpacker unpacker = msgpack.createBufferUnpacker(bytes);
	    String ret = tmpl.read(unpacker, null);
	    assertEquals(v, ret);
	}
    }

    private static class TestBufferPackUnpack extends TestSet {
	@Test @Override
	public void testString() throws Exception {
	    super.testString();
	}

	@Override
	public void testString(String v) throws Exception {
	    MessagePack msgpack = new MessagePack();
	    Template<String> tmpl = StringTemplate.instance;
	    BufferPacker packer = msgpack.createBufferPacker();
	    tmpl.write(packer, v);
	    byte[] bytes = packer.toByteArray();
	    Unpacker unpacker = msgpack.createUnpacker(new ByteArrayInputStream(bytes));
	    String ret = tmpl.read(unpacker, null);
	    assertEquals(v, ret);
	}
    }
}
