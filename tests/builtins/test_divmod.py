from .. utils import TranspileTestCase, BuiltinFunctionTestCase


class DivmodTests(TranspileTestCase):
    def test_int_int_zero_rem(self):
        self.assertCodeExecution("""
            x = 4
            y = 2
            print(divmod(x, y))
            print('Done.')
            """)

    def test_int_int_one_rem(self):
        self.assertCodeExecution("""
            x = 7
            y = 3
            print(divmod(x, y))
            print('Done.')
            """)

    def test_int_int_zero_divisor(self):
        self.assertCodeExecution("""
            x = 7
            y = 0
            print(divmod(x, y))
            print('Done.')
            """)

    def test_int_int_zero_dividend(self):
        self.assertCodeExecution("""
            x = 0
            y = 3
            print(divmod(x, y))
            print('Done.')
            """)

    def test_int_bool(self):
        self.assertCodeExecution("""
            x = 7
            y = True
            print(divmod(x, y))
            print('Done.')
            """)
    def test_int_float(self):
        self.assertCodeExecution("""
            x = 7
            y = 3.3
            print(divmod(x, y))
            print('Done.')
            """)

    def test_int_list_2(self):
        self.assertCodeExecution("""
            x = 7
            y = [3, 4]
            print(divmod(x, y))
            print('Done.')
            """)

    def test_int_list_1(self):
        self.assertCodeExecution("""
            x = 7
            y = [3]
            print(divmod(x, y))
            print('Done.')
            """)

    def test_int_list_0(self):
        self.assertCodeExecution("""
            x = 7
            y = []
            print(divmod(x, y))
            print('Done.')
            """)

    def test_int_none(self):
        self.assertCodeExecution("""
            x = 7
            y = None
            print(divmod(x, y))
            print('Done.')
            """)

    def test_int_str(self):
        self.assertCodeExecution("""
            x = 7
            y = 'abc'
            print(divmod(x, y))
            print('Done.')
            """)

    def test_int_str_empty(self):
        self.assertCodeExecution("""
            x = 7
            y = ''
            print(divmod(x, y))
            print('Done.')
            """)

    def test_float_float(self):
        self.assertCodeExecution("""
            x = 7.7
            y = 1.2
            print(divmod(x, y))
            print('Done.')
            """)

    def test_float_bool(self):
        self.assertCodeExecution("""
            x = 7.7
            y = True
            print(divmod(x, y))
            print('Done.')
            """)

    def test_float_int(self):
        self.assertCodeExecution("""
            x = 7.7
            y = 2
            print(divmod(x, y))
            print('Done.')
            """)

    def test_float_list(self):
        self.assertCodeExecution("""
            x = 7.7
            y = [3, 4]
            print(divmod(x, y))
            print('Done.')
            """)

    def test_float_none(self):
        self.assertCodeExecution("""
            x = 7.7
            y = None
            print(divmod(x, y))
            print('Done.')
            """)

    def test_float_str(self):
        self.assertCodeExecution("""
            x = 7.7
            y = 'abc'
            print(divmod(x, y))
            print('Done.')
            """)

    def test_list_list(self):
        self.assertCodeExecution("""
            x = [1, 2]
            y = [3, 4]
            print(divmod(x, y))
            print('Done.')
            """)

    def test_none_none(self):
        self.assertCodeExecution("""
            x = None
            y = None
            print(divmod(x, y))
            print('Done.')
            """)

    def test_none_bool(self):
        self.assertCodeExecution("""
            x = None
            y = True
            print(divmod(x, y))
            print('Done.')
            """)

    def test_none_int(self):
        self.assertCodeExecution("""
            x = None
            y = 7
            print(divmod(x, y))
            print('Done.')
            """)

    def test_none_float(self):
        self.assertCodeExecution("""
            x = None
            y = 7.7
            print(divmod(x, y))
            print('Done.')
            """)

    def test_none_str(self):
        self.assertCodeExecution("""
            x = None
            y = 'abc'
            print(divmod(x, y))
            print('Done.')
            """)

    def test_set_set(self):
        self.assertCodeExecution("""
            x = {1, 2}
            y = {3, 4}
            print(divmod(x, y))
            print('Done.')
            """)

    def test_str_str(self):
        self.assertCodeExecution("""
            x = 'abc'
            y = 'def'
            print(divmod(x, y))
            print('Done.')
            """)

    def test_tuple_tuple(self):
        self.assertCodeExecution("""
            x = (1, 2)
            y = (3, 4)
            print(divmod(x, y))
            print('Done.')
            """)


class BuiltinDivmodFunctionTests(BuiltinFunctionTestCase, TranspileTestCase):
    functions = ["divmod"]

    not_implemented = [
        'test_bool',
        'test_bytearray',
        'test_bytes',
        'test_class',
        'test_complex',
        'test_dict',
        'test_float',
        'test_frozenset',
        'test_int',
        'test_list',
        'test_none',
        'test_set',
        'test_str',
        'test_tuple',
    ]
