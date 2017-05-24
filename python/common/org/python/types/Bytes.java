package org.python.types;

import java.util.Arrays;

public class Bytes extends org.python.types.Object {
    public byte[] value;

    /**
     * A utility method to update the internal value of this object.
     *
     * Used by __i*__ operations to do an in-place operation.
     * obj must be of type org.python.types.Bytes
     */
    void setValue(org.python.Object obj) {
        this.value = ((org.python.types.Bytes) obj).value;
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public Bytes(byte[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    public Bytes(java.lang.String value) {
        try {
            this.value = value.getBytes("ISO-8859-1");
        } catch (java.io.UnsupportedEncodingException e) {
            throw new org.python.exceptions.UnicodeDecodeError();
        }
    }

    @org.python.Method(
            __doc__ = "bytes(iterable_of_ints) -> bytes" +
                    "bytes(string, encoding[, errors]) -> bytes\n" +
                    "bytes(bytes_or_buffer) -> immutable copy of bytes_or_buffer\n" +
                    "bytes(int) -> bytes object of size given by the parameter initialized with null bytes\n" +
                    "bytes() -> empty bytes object\n" +
                    "\n" +
                    "Construct an immutable array of bytes from:\n" +
                    " - an iterable yielding integers in range(256)\n" +
                    " - a text string encoded using the specified encoding\n" +
                    " - any object implementing the buffer API.\n" +
                    " - an integer\n",
            default_args = {"source", "encoding", "errors"}
    )
    public Bytes(org.python.Object[] args, java.util.Map<java.lang.String, org.python.Object> kwargs) {
        throw new org.python.exceptions.NotImplementedError("Builtin function 'bytes' not implemented");
    }

    // public org.python.Object __new__() {
    //     throw new org.python.exceptions.NotImplementedError("str.__new__() has not been implemented.");
    // }

    // public org.python.Object __init__() {
    //     throw new org.python.exceptions.NotImplementedError("str.__init__() has not been implemented.");
    // }

    @org.python.Method(
            __doc__ = ""
    )
    public org.python.types.Str __repr__() {
        return this.__str__();
    }

    @org.python.Method(
            __doc__ = ""
    )
    public org.python.types.Str __str__() {
        StringBuilder sb = new StringBuilder();
        sb.append("b'");
        for (int c : this.value) {
            if (c >= 32 && c < 128) {
                sb.append((char) c);
            } else {
                sb.append(String.format("\\x%02d", c));
            }
        }
        sb.append("'");
        return new org.python.types.Str(sb.toString());
    }

    @org.python.Method(
            __doc__ = "",
            args = {"other"}
    )
    public org.python.Object __eq__(org.python.Object other) {
        if (other instanceof org.python.types.Bytes) {
            byte[] other_value = ((org.python.types.Bytes) other).value;
            return new org.python.types.Bool(Arrays.equals(this.value, other_value));
        } else if (other instanceof org.python.types.ByteArray) {
            byte[] other_value = ((org.python.types.ByteArray) other).value;
            if (other_value == null) {
                other_value = new byte[0];
            }
            return new org.python.types.Bool(Arrays.equals(this.value, other_value));
        }
        return org.python.types.NotImplementedType.NOT_IMPLEMENTED;
    }

    @org.python.Method(
            __doc__ = ""
    )
    public org.python.Object __add__(org.python.Object other) {
        if (other instanceof org.python.types.Bytes) {
            byte[] other_bytes = (byte[]) ((org.python.types.Bytes) other).value;
            byte[] new_bytes = new byte[this.value.length + other_bytes.length];
            System.arraycopy(this.value, 0, new_bytes, 0, this.value.length);
            System.arraycopy(other_bytes, 0, new_bytes, this.value.length, other_bytes.length);
            return new Bytes(new_bytes);
        } else if (other instanceof org.python.types.ByteArray) {
            byte[] other_bytes = (byte[]) ((org.python.types.ByteArray) other).value;
            if (other_bytes == null) {
                return this;
            }
            byte[] new_bytes = new byte[this.value.length + other_bytes.length];
            System.arraycopy(this.value, 0, new_bytes, 0, this.value.length);
            System.arraycopy(other_bytes, 0, new_bytes, this.value.length, other_bytes.length);
            return new Bytes(new_bytes);
        }
        throw new org.python.exceptions.TypeError("can't concat bytes to " + other.typeName());
    }

    @org.python.Method(
            __doc__ = ""
    )
    public org.python.Object __iadd__(org.python.Object other) {
        return this.__add__(other);
    }

    @org.python.Method(
            __doc__ = ""
    )
    public org.python.Object __and__(org.python.Object other) {
        throw new org.python.exceptions.TypeError("unsupported operand type(s) for &: 'bytes' and '" + other.typeName() + "'");
    }

    @org.python.Method(
            __doc__ = ""
    )
    public org.python.Object __pos__() {
        throw new org.python.exceptions.TypeError("bad operand type for unary +: 'bytes'");
    }

    @org.python.Method(
            __doc__ = ""
    )
    public org.python.Object __neg__() {
        throw new org.python.exceptions.TypeError("bad operand type for unary -: 'bytes'");
    }

    @org.python.Method(
            __doc__ = ""
    )
    public org.python.Object __invert__() {
        throw new org.python.exceptions.TypeError("bad operand type for unary ~: 'bytes'");
    }

    @org.python.Method(
            __doc__ = ""
    )
    public org.python.Object __bool__() {
        return new org.python.types.Bool(this.value.length > 0);
    }

    @org.python.Method(
            __doc__ = ""
    )
    public org.python.Object __contains__(java.util.List<org.python.Object> args, java.util.Map<java.lang.String, org.python.Object> kwargs, java.util.List<org.python.Object> default_args, java.util.Map<java.lang.String, org.python.Object> default_kwargs) {
        throw new org.python.exceptions.NotImplementedError("bytes.__contains__ has not been implemented.");
    }

    @org.python.Method(
            __doc__ = ""
    )
    public org.python.types.Str __format__(java.util.List<org.python.Object> args, java.util.Map<java.lang.String, org.python.Object> kwargs, java.util.List<org.python.Object> default_args, java.util.Map<java.lang.String, org.python.Object> default_kwargs) {
        throw new org.python.exceptions.NotImplementedError("bytes.__format__ has not been implemented.");
    }

    @org.python.Method(
            __doc__ = "",
            args = {"other"}
    )
    public org.python.Object __ge__(org.python.Object other) {
        if (other instanceof org.python.types.Bytes) {
            byte[] other_bytes = (byte[]) ((org.python.types.Bytes) other).value;
            for (int i = 0; i < Math.min(this.value.length, other_bytes.length); i++) {
                if (this.value[i] > other_bytes[i]) {
                    return new org.python.types.Bool(1);
                }
                if (this.value[i] < other_bytes[i]) {
                    return new org.python.types.Bool(0);
                }
            }
            if (this.value.length < other_bytes.length) {
                return new org.python.types.Bool(0);
            }
            return new org.python.types.Bool(1);
        } else if (other instanceof org.python.types.ByteArray) {
            byte[] other_bytes = (byte[]) ((org.python.types.ByteArray) other).value;
            if (other_bytes == null) {
                return new org.python.types.Bool(1);
            }
            for (int i = 0; i < Math.min(this.value.length, other_bytes.length); i++) {
                if (this.value[i] > other_bytes[i]) {
                    return new org.python.types.Bool(1);
                }
                if (this.value[i] < other_bytes[i]) {
                    return new org.python.types.Bool(0);
                }
            }
            if (this.value.length < other_bytes.length) {
                return new org.python.types.Bool(0);
            }
            return new org.python.types.Bool(1);
        }
        return org.python.types.NotImplementedType.NOT_IMPLEMENTED;
    }

    @org.python.Method(
            __doc__ = "",
            args = {"other"}
    )
    public org.python.Object __gt__(org.python.Object other) {
        if (other instanceof org.python.types.Bytes) {
            byte[] other_bytes = (byte[]) ((org.python.types.Bytes) other).value;
            for (int i = 0; i < Math.min(this.value.length, other_bytes.length); i++) {
                if (this.value[i] > other_bytes[i]) {
                    return new org.python.types.Bool(1);
                }
                if (this.value[i] < other_bytes[i]) {
                    return new org.python.types.Bool(0);
                }
            }
            if (this.value.length <= other_bytes.length) {
                return new org.python.types.Bool(0);
            }
            return new org.python.types.Bool(1);
        } else if (other instanceof org.python.types.ByteArray) {
            byte[] other_bytes = (byte[]) ((org.python.types.ByteArray) other).value;
            if (other_bytes == null) {
                other_bytes = new byte[0];
            }
            for (int i = 0; i < Math.min(this.value.length, other_bytes.length); i++) {
                if (this.value[i] > other_bytes[i]) {
                    return new org.python.types.Bool(1);
                }
                if (this.value[i] < other_bytes[i]) {
                    return new org.python.types.Bool(0);
                }
            }
            if (this.value.length <= other_bytes.length) {
                return new org.python.types.Bool(0);
            }
            return new org.python.types.Bool(1);
        }
        return org.python.types.NotImplementedType.NOT_IMPLEMENTED;
    }

    @org.python.Method(
            __doc__ = "",
            args = {"other"}
    )
    public org.python.Object __le__(org.python.Object other) {
        if (other instanceof org.python.types.Bytes) {
            byte[] other_bytes = (byte[]) ((org.python.types.Bytes) other).value;
            for (int i = 0; i < Math.min(this.value.length, other_bytes.length); i++) {
                if (this.value[i] < other_bytes[i]) {
                    return new org.python.types.Bool(1);
                }
                if (this.value[i] > other_bytes[i]) {
                    return new org.python.types.Bool(0);
                }
            }
            if (this.value.length <= other_bytes.length) {
                return new org.python.types.Bool(1);
            }
            return new org.python.types.Bool(0);
        } else if (other instanceof org.python.types.ByteArray) {
            byte[] other_bytes = (byte[]) ((org.python.types.ByteArray) other).value;
            if (other_bytes == null) {
                other_bytes = new byte[0];
            }
            for (int i = 0; i < Math.min(this.value.length, other_bytes.length); i++) {
                if (this.value[i] < other_bytes[i]) {
                    return new org.python.types.Bool(1);
                }
                if (this.value[i] > other_bytes[i]) {
                    return new org.python.types.Bool(0);
                }
            }
            if (this.value.length <= other_bytes.length) {
                return new org.python.types.Bool(1);
            }
            return new org.python.types.Bool(0);
        }
        return org.python.types.NotImplementedType.NOT_IMPLEMENTED;
    }

    @org.python.Method(
            __doc__ = "",
            args = {"other"}
    )
    public org.python.Object __lt__(org.python.Object other) {
        if (other instanceof org.python.types.Bytes) {
            byte[] other_bytes = (byte[]) ((org.python.types.Bytes) other).value;
            for (int i = 0; i < Math.min(this.value.length, other_bytes.length); i++) {
                if (this.value[i] < other_bytes[i]) {
                    return new org.python.types.Bool(1);
                }
                if (this.value[i] > other_bytes[i]) {
                    return new org.python.types.Bool(0);
                }
            }
            if (this.value.length < other_bytes.length) {
                return new org.python.types.Bool(1);
            }
            return new org.python.types.Bool(0);
        } else if (other instanceof org.python.types.ByteArray) {
            byte[] other_bytes = (byte[]) ((org.python.types.ByteArray) other).value;
            if (other_bytes == null) {
                return new org.python.types.Bool(0);
            }
            for (int i = 0; i < Math.min(this.value.length, other_bytes.length); i++) {
                if (this.value[i] < other_bytes[i]) {
                    return new org.python.types.Bool(1);
                }
                if (this.value[i] > other_bytes[i]) {
                    return new org.python.types.Bool(0);
                }
            }
            if (this.value.length < other_bytes.length) {
                return new org.python.types.Bool(1);
            }
            return new org.python.types.Bool(0);
        }
        return org.python.types.NotImplementedType.NOT_IMPLEMENTED;
    }

    @org.python.Method(
            __doc__ = ""
    )
    public org.python.Object __mod__(org.python.Object other) {
        if (org.Python.VERSION < 0x03050000) {
            if (other instanceof org.python.types.Dict) {
                return this;
            }
            throw new org.python.exceptions.TypeError(
                    "unsupported operand type(s) for %: 'bytes' and '" + other.typeName() + "'"
            );
        } else {
            if (other instanceof org.python.types.List || other instanceof org.python.types.Range) {
                return this;
            }
            throw new org.python.exceptions.TypeError("not all arguments converted during bytes formatting");
        }
    }

    @org.python.Method(
            __doc__ = ""
    )
    public org.python.Object __getitem__(org.python.Object index) {
        if (index instanceof org.python.types.Slice) {
            org.python.types.Slice slice = (org.python.types.Slice) index;
            byte[] sliced;

            if (slice.start == null && slice.stop == null && slice.step == null) {
                sliced = this.value;
            } else {
                int start;
                if (slice.start != null) {
                    start = (int) slice.start.value;
                } else {
                    start = 0;
                }

                int stop;
                if (slice.stop != null) {
                    stop = (int) slice.stop.value;
                } else {
                    stop = this.value.length;
                }

                int step;
                if (slice.step != null) {
                    step = (int) slice.step.value;
                } else {
                    step = 1;
                }

                // System.err.format("start:%d, stop:%d, step:%d\n", start, stop, step);
                if (step > 0) {
                    if (start >= this.value.length || stop >= this.value.length || start > stop) {
                        return new Bytes(new byte[0]);
                    }

                    int len = (int) Math.ceil((float) (stop - start) / step);
                    sliced = new byte[len];

                    for (int i = 0, j = start; j < stop; i++, j += step) {
                        // System.err.format("this.value[%d] -> sliced[%d]\n", j, i);
                        sliced[i] = this.value[j];
                    }
                } else { // step < 0
                    if (Math.abs(start) >= this.value.length || Math.abs(stop) >= this.value.length || stop > start) {
                        return new Bytes(new byte[0]);
                    }

                    int len = (int) Math.ceil((float) (stop - start) / step);
                    sliced = new byte[len];

                    for (int i = 0, j = start; j > stop; i++, j += step) {
                        // System.err.format("this.value[%d] -> sliced[%d]\n", j, i);
                        sliced[i] = this.value[j];
                    }
                }
            }
            return new Bytes(sliced);
        } else if (index instanceof org.python.types.Bool || index instanceof org.python.types.Int) {
            int idx;
            if (index instanceof org.python.types.Bool) {
                boolean index_bool = ((org.python.types.Bool) index).value;
                if (index_bool) {
                    idx = 1;
                } else {
                    idx = 0;
                }
            } else {
                idx = (int) ((org.python.types.Int) index).value;
            }

            if (idx < 0) {
                if (-idx > this.value.length) {
                    throw new org.python.exceptions.IndexError("index out of range");
                } else {
                    idx = this.value.length + idx;
                    // return new Bytes(java.util.Arrays.copyOfRange(this.value, idx, idx));
                    return new org.python.types.Int(this.value[idx]);
                }
            } else {
                if (idx >= this.value.length) {
                    throw new org.python.exceptions.IndexError("index out of range");
                } else {
                    // return new Bytes(java.util.Arrays.copyOfRange(this.value, idx, idx));
                    return new org.python.types.Int(this.value[idx]);
                }
            }
        } else {
            if (org.Python.VERSION < 0x03050000) {
                throw new org.python.exceptions.TypeError("byte indices must be integers, not " + index.typeName());
            } else {
                throw new org.python.exceptions.TypeError(
                        "byte indices must be integers or slices, not " + index.typeName()
                );
            }
        }
    }

    @org.python.Method(
            __doc__ = ""
    )
    public org.python.Object __getnewargs__(java.util.List<org.python.Object> args, java.util.Map<java.lang.String, org.python.Object> kwargs, java.util.List<org.python.Object> default_args, java.util.Map<java.lang.String, org.python.Object> default_kwargs) {
        throw new org.python.exceptions.NotImplementedError("bytes.__getnewargs__ has not been implemented.");
    }

    public boolean __setattr_null(java.lang.String name, org.python.Object value) {
        // Builtin types can't have attributes set on them.
        return false;
    }

    @org.python.Method(
            __doc__ = ""
    )
    public org.python.Iterable __iter__() {
        java.util.List<org.python.Object> listOfBytes = new java.util.ArrayList<org.python.Object>();
        for (byte b: this.value) {
            listOfBytes.add(new org.python.types.Int(b));
        }
        return new org.python.types.List(listOfBytes).__iter__();
    }

    @org.python.Method(
            __doc__ = ""
    )
    public org.python.types.Int __len__() {
        return new org.python.types.Int(this.value.length);
    }

    @org.python.Method(
            __doc__ = ""
    )
    public org.python.Object __mul__(org.python.Object other) {
        if (other instanceof org.python.types.Bool) {
            boolean other_bool = ((org.python.types.Bool) other).value;
            if (other_bool) {
                return this;
            } else {
                return new Bytes(new byte[0]);
            }
        }
        if (other instanceof org.python.types.Int) {
            int other_value = Math.max(0, (int) ((org.python.types.Int) other).value);
            int len = this.value.length;
            byte[] bytes = new byte[other_value * len];
            for (int i = 0; i < other_value; i++) {
                System.arraycopy(this.value, 0, bytes, i * len, len);
            }
            return new Bytes(bytes);
        } else {
            throw new org.python.exceptions.TypeError("can't multiply sequence by non-int of type '" + other.typeName() + "'");
        }
    }

    @org.python.Method(
            __doc__ = ""
    )
    public org.python.Object __imul__(org.python.Object other) {
        return this.__mul__(other);
    }

    @org.python.Method(
            __doc__ = ""
    )
    public org.python.Object __imod__(org.python.Object other) {
        if (org.Python.VERSION < 0x03050000) {
            throw new org.python.exceptions.TypeError(
                    "unsupported operand type(s) for %=: 'bytes' and '" + other.typeName() + "'"
            );
        } else {
            if (other instanceof org.python.types.List || other instanceof org.python.types.Range) {
                return this.__mod__(other);
            }
            throw new org.python.exceptions.TypeError("not all arguments converted during bytes formatting");
        }
    }

    @org.python.Method(
            __doc__ = ""
    )
    public org.python.Object __reduce__(java.util.List<org.python.Object> args, java.util.Map<java.lang.String, org.python.Object> kwargs, java.util.List<org.python.Object> default_args, java.util.Map<java.lang.String, org.python.Object> default_kwargs) {
        throw new org.python.exceptions.NotImplementedError("bytes.__reduce__ has not been implemented.");
    }

    @org.python.Method(
            __doc__ = ""
    )
    public org.python.Object __reduce_ex__(java.util.List<org.python.Object> args, java.util.Map<java.lang.String, org.python.Object> kwargs, java.util.List<org.python.Object> default_args, java.util.Map<java.lang.String, org.python.Object> default_kwargs) {
        throw new org.python.exceptions.NotImplementedError("bytes.__reduce_ex__ has not been implemented.");
    }

    @org.python.Method(
            __doc__ = ""
    )
    public org.python.Object __rmul__(java.util.List<org.python.Object> args, java.util.Map<java.lang.String, org.python.Object> kwargs, java.util.List<org.python.Object> default_args, java.util.Map<java.lang.String, org.python.Object> default_kwargs) {
        throw new org.python.exceptions.NotImplementedError("bytes.__rmul__ has not been implemented.");
    }

    @org.python.Method(
            __doc__ = ""
    )
    public org.python.Object capitalize() {
        byte[] value = new byte[this.value.length];
        for (int i = 0; i < this.value.length; i++) {
            byte b = this.value[i];
            if (b < 127 && b > 32) {
                char c = (char) b;
                if (i == 0) {
                    c = Character.toUpperCase(c);
                } else {
                    c = Character.toLowerCase(c);
                }
                value[i] = (byte) c;
            } else {
                value[i] = b;
            }
        }
        return new Bytes(value);
    }

    @org.python.Method(
            __doc__ = ""
    )
    public org.python.Object center(java.util.List<org.python.Object> args, java.util.Map<java.lang.String, org.python.Object> kwargs, java.util.List<org.python.Object> default_args, java.util.Map<java.lang.String, org.python.Object> default_kwargs) {
        throw new org.python.exceptions.NotImplementedError("bytes.center has not been implemented.");
    }

    @org.python.Method(
            __doc__ = ""
    )
    public org.python.Object count(java.util.List<org.python.Object> args, java.util.Map<java.lang.String, org.python.Object> kwargs, java.util.List<org.python.Object> default_args, java.util.Map<java.lang.String, org.python.Object> default_kwargs) {
        throw new org.python.exceptions.NotImplementedError("bytes.count has not been implemented.");
    }

    @org.python.Method(
            __doc__ = ""
    )
    public org.python.Object decode(java.util.List<org.python.Object> args, java.util.Map<java.lang.String, org.python.Object> kwargs, java.util.List<org.python.Object> default_args, java.util.Map<java.lang.String, org.python.Object> default_kwargs) {
        try {
            return new org.python.types.Str(new java.lang.String(this.value, "UTF-8"));
            // return new org.python.types.Str(new java.lang.String(this.value, encoding));
        } catch (java.io.UnsupportedEncodingException e) {
            throw new org.python.exceptions.UnicodeDecodeError();
        }
    }

    @org.python.Method(
            __doc__ = ""
    )
    public org.python.Object endswith(java.util.List<org.python.Object> args, java.util.Map<java.lang.String, org.python.Object> kwargs, java.util.List<org.python.Object> default_args, java.util.Map<java.lang.String, org.python.Object> default_kwargs) {
        throw new org.python.exceptions.NotImplementedError("bytes.endswith has not been implemented.");
    }

    @org.python.Method(
            __doc__ = ""
    )
    public org.python.Object expandtabs(java.util.List<org.python.Object> args, java.util.Map<java.lang.String, org.python.Object> kwargs, java.util.List<org.python.Object> default_args, java.util.Map<java.lang.String, org.python.Object> default_kwargs) {
        throw new org.python.exceptions.NotImplementedError("bytes.expandtabs has not been implemented.");
    }

    @org.python.Method(
            __doc__ = "",
            args = {"sub"},
            default_args = {"start", "end"}
    )
    public org.python.types.Int find(org.python.Object sub, org.python.Object start, org.python.Object end) {
        int _start = 0;
        int _end = 0;
        if (start != null && !(start instanceof org.python.types.NoneType)) {
            _start = (int) ((Int) start).value;
        }
        if (end == null || end instanceof org.python.types.NoneType) {
            _end = this.value.length;
        }
        Bytes _sub = (Bytes) sub;
        if (_sub.value.length <= 0) {
            return new Int(0);
        }
        int pos = -1;
        for (int i = 0; _start < _end; _start++) {
            byte b1 = this.value[_start];
            byte b2 = _sub.value[i];
            if (b1 == b2) {
                i++;
                if (pos == -1) {
                    pos = _start;
                }
            }
            if (i == _sub.value.length) {
                break;
            }
            if (b1 != b2) {
                i = 0;
                pos = -1;
            }
        }
        return new Int(pos);
    }

    @org.python.Method(
            __doc__ = ""
    )
    public org.python.Object fromhex(java.util.List<org.python.Object> args, java.util.Map<java.lang.String, org.python.Object> kwargs, java.util.List<org.python.Object> default_args, java.util.Map<java.lang.String, org.python.Object> default_kwargs) {
        throw new org.python.exceptions.NotImplementedError("bytes.fromhex has not been implemented.");
    }

    @org.python.Method(
            __doc__ = ""
    )
    public org.python.Object index(java.util.List<org.python.Object> args, java.util.Map<java.lang.String, org.python.Object> kwargs, java.util.List<org.python.Object> default_args, java.util.Map<java.lang.String, org.python.Object> default_kwargs) {
        throw new org.python.exceptions.NotImplementedError("bytes.index has not been implemented.");
    }

    @org.python.Method(
            __doc__ = "Return True if all characters in B are alphanumeric\n" +
                      "and there is at least one character in B, False otherwise."
    )
    public org.python.Object isalnum() {
        for (byte ch : this.value) {
            if (!Character.isLetterOrDigit(ch)) {
                return new org.python.types.Bool(false);
            }
        }
        return new org.python.types.Bool(true);
    }

    @org.python.Method(
            __doc__ = "Return True if all characters in B are alphabetic\n" +
                      "and there is at least one character in B, False otherwise."
    )
    public org.python.Object isalpha() {
        for (byte ch : this.value) {
            if (!Character.isLetter(ch)) {
                return new org.python.types.Bool(false);
            }
        }
        return new org.python.types.Bool(true);
    }

    @org.python.Method(
            __doc__ = "Return True if all characters in B are digits\n" +
                      "and there is at least one character in B, False otherwise."
    )
    public org.python.Object isdigit() {
        for (byte ch : this.value) {
            if (!Character.isDigit(ch)) {
                return new org.python.types.Bool(false);
            }
        }
        return new org.python.types.Bool(true);
    }

    @org.python.Method(
            __doc__ = "Return True if all cased characters in B are lowercase and there is\n" +
                      "at least one cased character in B, False otherwise."
    )
    public org.python.Object islower() {
        boolean notJustDigits = false;
        for (byte ch : this.value) {
            if (!Character.isDigit(ch)) {
                if (!Character.isLowerCase(ch)) {
                    return new org.python.types.Bool(false);
                }
                notJustDigits = true;
            }
        }
        return new org.python.types.Bool(notJustDigits);
    }

    @org.python.Method(
            __doc__ = "Return True if all characters in B are whitespace\n" +
                      "and there is at least one character in B, False otherwise."
    )
    public org.python.Object isspace() {
        for (byte ch : this.value) {
            if (!Character.isWhitespace(ch)) {
                return new org.python.types.Bool(false);
            }
        }
        return new org.python.types.Bool(true);
    }

    @org.python.Method(
            __doc__ = "Return True if B is a titlecased string and there is at least one\n" +
                      "character in B, i.e. uppercase characters may only follow uncased\n" +
                      "characters and lowercase characters only cased ones. Return False\n" +
                      "otherwise."
    )
    public org.python.Object istitle() {
        boolean firstChar = true;
        for (byte ch : this.value) {
            if (firstChar) {
                if (!Character.isLowerCase(ch)) {
                    return new org.python.types.Bool(false);
                }
                firstChar = false;
            } else {
                if (!Character.isDigit(ch)) {
                    if (!Character.isUpperCase(ch)) {
                        return new org.python.types.Bool(false);
                    }
                }
            }
        }
        return new org.python.types.Bool(true);
    }

    @org.python.Method(
            __doc__ = "Return True if all cased characters in B are uppercase and there is\n" +
                      "at least one cased character in B, False otherwise."
    )
    public org.python.Object isupper() {
        boolean notJustDigits = false;
        for (byte ch : this.value) {
            if (!Character.isDigit(ch)) {
                if (!Character.isUpperCase(ch)) {
                    return new org.python.types.Bool(false);
                }
                notJustDigits = true;
            }
        }
        return new org.python.types.Bool(notJustDigits);
    }

    @org.python.Method(
            __doc__ = ""
    )
    public org.python.Object join(java.util.List<org.python.Object> args, java.util.Map<java.lang.String, org.python.Object> kwargs, java.util.List<org.python.Object> default_args, java.util.Map<java.lang.String, org.python.Object> default_kwargs) {
        throw new org.python.exceptions.NotImplementedError("bytes.join has not been implemented.");
    }

    @org.python.Method(
            __doc__ = ""
    )
    public org.python.Object ljust(java.util.List<org.python.Object> args, java.util.Map<java.lang.String, org.python.Object> kwargs, java.util.List<org.python.Object> default_args, java.util.Map<java.lang.String, org.python.Object> default_kwargs) {
        throw new org.python.exceptions.NotImplementedError("bytes.ljust has not been implemented.");
    }

    @org.python.Method(
            __doc__ = ""
    )
    public org.python.Object lower(java.util.List<org.python.Object> args, java.util.Map<java.lang.String, org.python.Object> kwargs, java.util.List<org.python.Object> default_args, java.util.Map<java.lang.String, org.python.Object> default_kwargs) {
        throw new org.python.exceptions.NotImplementedError("bytes.lower has not been implemented.");
    }

    @org.python.Method(
            __doc__ = ""
    )
    public org.python.Object lstrip(java.util.List<org.python.Object> args, java.util.Map<java.lang.String, org.python.Object> kwargs, java.util.List<org.python.Object> default_args, java.util.Map<java.lang.String, org.python.Object> default_kwargs) {
        throw new org.python.exceptions.NotImplementedError("bytes.lstrip has not been implemented.");
    }

    @org.python.Method(
            __doc__ = ""
    )
    public org.python.Object maketrans(java.util.List<org.python.Object> args, java.util.Map<java.lang.String, org.python.Object> kwargs, java.util.List<org.python.Object> default_args, java.util.Map<java.lang.String, org.python.Object> default_kwargs) {
        throw new org.python.exceptions.NotImplementedError("bytes.maketrans has not been implemented.");
    }

    @org.python.Method(
            __doc__ = ""
    )
    public org.python.Object partition(java.util.List<org.python.Object> args, java.util.Map<java.lang.String, org.python.Object> kwargs, java.util.List<org.python.Object> default_args, java.util.Map<java.lang.String, org.python.Object> default_kwargs) {
        throw new org.python.exceptions.NotImplementedError("bytes.partition has not been implemented.");
    }

    @org.python.Method(
            __doc__ = ""
    )
    public org.python.Object replace(java.util.List<org.python.Object> args, java.util.Map<java.lang.String, org.python.Object> kwargs, java.util.List<org.python.Object> default_args, java.util.Map<java.lang.String, org.python.Object> default_kwargs) {
        throw new org.python.exceptions.NotImplementedError("bytes.replace has not been implemented.");
    }

    @org.python.Method(
            __doc__ = ""
    )
    public org.python.Object rfind(java.util.List<org.python.Object> args, java.util.Map<java.lang.String, org.python.Object> kwargs, java.util.List<org.python.Object> default_args, java.util.Map<java.lang.String, org.python.Object> default_kwargs) {
        throw new org.python.exceptions.NotImplementedError("bytes.rfind has not been implemented.");
    }

    @org.python.Method(
            __doc__ = ""
    )
    public org.python.Object rindex(java.util.List<org.python.Object> args, java.util.Map<java.lang.String, org.python.Object> kwargs, java.util.List<org.python.Object> default_args, java.util.Map<java.lang.String, org.python.Object> default_kwargs) {
        throw new org.python.exceptions.NotImplementedError("bytes.rindex has not been implemented.");
    }

    @org.python.Method(
            __doc__ = ""
    )
    public org.python.Object rjust(java.util.List<org.python.Object> args, java.util.Map<java.lang.String, org.python.Object> kwargs, java.util.List<org.python.Object> default_args, java.util.Map<java.lang.String, org.python.Object> default_kwargs) {
        throw new org.python.exceptions.NotImplementedError("bytes.rjust has not been implemented.");
    }

    @org.python.Method(
            __doc__ = ""
    )
    public org.python.Object rpartition(java.util.List<org.python.Object> args, java.util.Map<java.lang.String, org.python.Object> kwargs, java.util.List<org.python.Object> default_args, java.util.Map<java.lang.String, org.python.Object> default_kwargs) {
        throw new org.python.exceptions.NotImplementedError("bytes.rpartition has not been implemented.");
    }

    @org.python.Method(
            __doc__ = ""
    )
    public org.python.Object rsplit(java.util.List<org.python.Object> args, java.util.Map<java.lang.String, org.python.Object> kwargs, java.util.List<org.python.Object> default_args, java.util.Map<java.lang.String, org.python.Object> default_kwargs) {
        throw new org.python.exceptions.NotImplementedError("bytes.rsplit has not been implemented.");
    }

    @org.python.Method(
            __doc__ = ""
    )
    public org.python.Object rstrip(java.util.List<org.python.Object> args, java.util.Map<java.lang.String, org.python.Object> kwargs, java.util.List<org.python.Object> default_args, java.util.Map<java.lang.String, org.python.Object> default_kwargs) {
        throw new org.python.exceptions.NotImplementedError("bytes.rstrip has not been implemented.");
    }

    @org.python.Method(
            __doc__ = ""
    )
    public org.python.Object split(java.util.List<org.python.Object> args, java.util.Map<java.lang.String, org.python.Object> kwargs, java.util.List<org.python.Object> default_args, java.util.Map<java.lang.String, org.python.Object> default_kwargs) {
        throw new org.python.exceptions.NotImplementedError("bytes.split has not been implemented.");
    }

    @org.python.Method(
            __doc__ = ""
    )
    public org.python.Object splitlines(java.util.List<org.python.Object> args, java.util.Map<java.lang.String, org.python.Object> kwargs, java.util.List<org.python.Object> default_args, java.util.Map<java.lang.String, org.python.Object> default_kwargs) {
        throw new org.python.exceptions.NotImplementedError("bytes.splitlines has not been implemented.");
    }

    @org.python.Method(
            __doc__ = ""
    )
    public org.python.Object startswith(java.util.List<org.python.Object> args, java.util.Map<java.lang.String, org.python.Object> kwargs, java.util.List<org.python.Object> default_args, java.util.Map<java.lang.String, org.python.Object> default_kwargs) {
        throw new org.python.exceptions.NotImplementedError("bytes.startswith has not been implemented.");
    }

    @org.python.Method(
            __doc__ = ""
    )
    public org.python.Object strip(java.util.List<org.python.Object> args, java.util.Map<java.lang.String, org.python.Object> kwargs, java.util.List<org.python.Object> default_args, java.util.Map<java.lang.String, org.python.Object> default_kwargs) {
        throw new org.python.exceptions.NotImplementedError("bytes.strip has not been implemented.");
    }

    @org.python.Method(
            __doc__ = ""
    )
    public org.python.Object swapcase(java.util.List<org.python.Object> args, java.util.Map<java.lang.String, org.python.Object> kwargs, java.util.List<org.python.Object> default_args, java.util.Map<java.lang.String, org.python.Object> default_kwargs) {
        throw new org.python.exceptions.NotImplementedError("bytes.swapcase has not been implemented.");
    }

    @org.python.Method(
            __doc__ = ""
    )
    public org.python.Object title(java.util.List<org.python.Object> args, java.util.Map<java.lang.String, org.python.Object> kwargs, java.util.List<org.python.Object> default_args, java.util.Map<java.lang.String, org.python.Object> default_kwargs) {
        throw new org.python.exceptions.NotImplementedError("bytes.title has not been implemented.");
    }

    @org.python.Method(
            __doc__ = ""
    )
    public org.python.Object translate(java.util.List<org.python.Object> args, java.util.Map<java.lang.String, org.python.Object> kwargs, java.util.List<org.python.Object> default_args, java.util.Map<java.lang.String, org.python.Object> default_kwargs) {
        throw new org.python.exceptions.NotImplementedError("bytes.translate has not been implemented.");
    }

    @org.python.Method(
            __doc__ = ""
    )
    public org.python.Object upper(java.util.List<org.python.Object> args, java.util.Map<java.lang.String, org.python.Object> kwargs, java.util.List<org.python.Object> default_args, java.util.Map<java.lang.String, org.python.Object> default_kwargs) {
        throw new org.python.exceptions.NotImplementedError("bytes.upper has not been implemented.");
    }

    @org.python.Method(
            __doc__ = ""
    )
    public org.python.Object zfill(java.util.List<org.python.Object> args, java.util.Map<java.lang.String, org.python.Object> kwargs, java.util.List<org.python.Object> default_args, java.util.Map<java.lang.String, org.python.Object> default_kwargs) {
        throw new org.python.exceptions.NotImplementedError("bytes.zfill has not been implemented.");
    }
}
