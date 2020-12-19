import { Input } from 'antd';
import { AudioOutlined } from '@ant-design/icons';

const { Search } = Input;

const suffix = (
  <AudioOutlined
    style={{
      fontSize: 16,
      color: '#1890ff',
    }}
  />
);

const onSearch = value => console.log(value);
  <>
    <Search
      placeholder="input search text"
      allowClear
      onSearch={onSearch}
      style={{ width: 50, margin: '0 10px' }}
    />
    <br />
    <br />
    <br />
    <br />
  </>
  export default Search
