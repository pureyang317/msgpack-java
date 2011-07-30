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


public class TestFloatArrayTemplate {

    @Test
    public void testPackUnpack00() throws Exception {
	new TestPackUnpack(0).testFloatArray();
    }

    @Test
    public void testPackUnpack01() throws Exception {
	new TestPackUnpack(1).testFloatArray();
    }

    @Test
    public void testPackUnpack02() throws Exception {
	new TestPackUnpack(2).testFloatArray();
    }

    @Test
    public void testPackBufferUnpack00() throws Exception {
	new TestPackBufferUnpack(0).testFloatArray();
    }

    @Test
    public void testPackBufferUnpack01() throws Exception {
	new TestPackBufferUnpack(1).testFloatArray();
    }

    @Test
    public void testPackBufferUnpack02() throws Exception {
	new TestPackBufferUnpack(2).testFloatArray();
    }

    @Test
    public void testBufferPackBufferUnpack00() throws Exception {
	new TestBufferPackBufferUnpack(0).testFloatArray();
    }

    @Test
    public void testBufferPackBufferUnpack01() throws Exception {
	new TestBufferPackBufferUnpack(1).testFloatArray();
    }

    @Test
    public void testBufferPackBufferUnpack02() throws Exception {
	new TestBufferPackBufferUnpack(2).testFloatArray();
    }

    @Test
    public void testBufferPackUnpack00() throws Exception {
	new TestBufferPackUnpack(0).testFloatArray();
    }

    @Test
    public void testBufferPackUnpack01() throws Exception {
	new TestBufferPackUnpack(1).testFloatArray();
    }

    @Test
    public void testBufferPackUnpack02() throws Exception {
	new TestBufferPackUnpack(2).testFloatArray();
    }

    private static class TestPackUnpack extends TestSet {
	private int index;

	TestPackUnpack(int i) {
	    index = i;
	}

	@Test @Override
	public void testFloatArray() throws Exception {
	    super.testFloatArray();
	}

	@Override
	public void testFloatArray(float[] v) throws Exception {
	    MessagePack msgpack = new MessagePack();
	    Template<float[]> tmpl = FloatArrayTemplate.instance;
	    ByteArrayOutputStream out = new ByteArrayOutputStream();
	    Packer packer = msgpack.createPacker(out);
	    tmpl.write(packer, v);
	    byte[] bytes = out.toByteArray();
	    Unpacker unpacker = msgpack.createUnpacker(new ByteArrayInputStream(bytes));
	    float[] ret0;
	    switch (index) {
	    case 0:
		ret0 = null;
		break;
	    case 1:
		ret0 = new float[v.length];
		break;
	    case 2:
		ret0 = new float[(int) v.length / 2];
		break;
	    default:
		throw new IllegalArgumentException();
	    }
	    float[] ret = tmpl.read(unpacker, ret0);
	    assertEquals(v.length, ret.length);
	    for (int i = 0; i < v.length; ++i) {
		assertEquals(v[i], ret[i], 10e-10);
	    }
	}
    }

    private static class TestPackBufferUnpack extends TestSet {
	private int index;

	TestPackBufferUnpack(int i) {
	    index = i;
	}

	@Test @Override
	public void testFloatArray() throws Exception {
	    super.testFloatArray();
	}

	@Override
	public void testFloatArray(float[] v) throws Exception {
	    MessagePack msgpack = new MessagePack();
	    Template<float[]> tmpl = FloatArrayTemplate.instance;
	    ByteArrayOutputStream out = new ByteArrayOutputStream();
	    Packer packer = msgpack.createPacker(out);
	    tmpl.write(packer, v);
	    byte[] bytes = out.toByteArray();
	    BufferUnpacker unpacker = msgpack.createBufferUnpacker(bytes);
	    float[] ret0;
	    switch (index) {
	    case 0:
		ret0 = null;
		break;
	    case 1:
		ret0 = new float[v.length];
		break;
	    case 2:
		ret0 = new float[(int) v.length / 2];
		break;
	    default:
		throw new IllegalArgumentException();
	    }
	    float[] ret = tmpl.read(unpacker, ret0);
	    assertEquals(v.length, ret.length);
	    for (int i = 0; i < v.length; ++i) {
		assertEquals(v[i], ret[i], 10e-10);
	    }
	}
    }

    private static class TestBufferPackBufferUnpack extends TestSet {
	private int index;

	TestBufferPackBufferUnpack(int i) {
	    index = i;
	}

	@Test @Override
	public void testFloatArray() throws Exception {
	    super.testFloatArray();
	}

	@Override
	public void testFloatArray(float[] v) throws Exception {
	    MessagePack msgpack = new MessagePack();
	    Template<float[]> tmpl = FloatArrayTemplate.instance;
	    BufferPacker packer = msgpack.createBufferPacker();
	    tmpl.write(packer, v);
	    byte[] bytes = packer.toByteArray();
	    BufferUnpacker unpacker = msgpack.createBufferUnpacker(bytes);
	    unpacker.wrap(bytes);
	    float[] ret0;
	    switch (index) {
	    case 0:
		ret0 = null;
		break;
	    case 1:
		ret0 = new float[v.length];
		break;
	    case 2:
		ret0 = new float[(int) v.length / 2];
		break;
	    default:
		throw new IllegalArgumentException();
	    }
	    float[] ret = tmpl.read(unpacker, ret0);
	    assertEquals(v.length, ret.length);
	    for (int i = 0; i < v.length; ++i) {
		assertEquals(v[i], ret[i], 10e-10);
	    }
	}
    }

    private static class TestBufferPackUnpack extends TestSet {
	private int index;

	TestBufferPackUnpack(int i) {
	    index = i;
	}

	@Test @Override
	public void testFloatArray() throws Exception {
	    super.testFloatArray();
	}

	@Override
	public void testFloatArray(float[] v) throws Exception {
	    MessagePack msgpack = new MessagePack();
	    Template<float[]> tmpl = FloatArrayTemplate.instance;
	    BufferPacker packer = msgpack.createBufferPacker();
	    tmpl.write(packer, v);
	    byte[] bytes = packer.toByteArray();
	    Unpacker unpacker = msgpack.createUnpacker(new ByteArrayInputStream(bytes));
	    float[] ret0;
	    switch (index) {
	    case 0:
		ret0 = null;
		break;
	    case 1:
		ret0 = new float[v.length];
		break;
	    case 2:
		ret0 = new float[(int) v.length / 2];
		break;
	    default:
		throw new IllegalArgumentException();
	    }
	    float[] ret = tmpl.read(unpacker, ret0);
	    assertEquals(v.length, ret.length);
	    for (int i = 0; i < v.length; ++i) {
		assertEquals(v[i], ret[i], 10e-10);
	    }
	}
    }
}
