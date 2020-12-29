import { Table } from 'antd';
import {PushpinFilled} from '@ant-design/icons';

const columns = [
    {
      title: 'First Name',
      width: 150,
      dataIndex: 'firstname',
      key: 'firstname',
      fixed: 'left', 
      icon : <PushpinFilled />,
    },
    {
      title: 'Last Name',
      width: 150,
      dataIndex: 'lastname',
      key: 'lastname',
      fixed: 'left',
    },
    {
      title: 'Status',
      width: 150,
      dataIndex: 'status',
      key: 'status',
      fixed: 'left',
    },
    // { title: 'Score', width: 150, dataIndex: 'score', key: '1' },
    { title: 'Interested', width: 150, dataIndex: 'interested', key: '2' },
    { title: 'Technical Interview', width: 200, dataIndex: 'technicalinterview', key: '3' },
    { title: 'Offer Job', width: 150, dataIndex: 'offerjob', key: '4' },
    { title: 'Accepted', width: 150, dataIndex: 'accepted', key: '5' },
    { title: 'Keep Warm Email', width: 150, dataIndex: 'keepwarmemail', key: '6' },
    { title: 'Keep Warm Call 1', width: 150, dataIndex: 'keepwarmcall1', key: '7' },
    { title: 'Keep Warm Call 2', width: 150, dataIndex: 'keepwarmcall2', key: '8' },
    { title: 'Notes', width: 500, dataIndex: 'notes', key: '9' },

  {
    title: 'Action',
    key: 'operation',
    fixed: 'right',
    width: 100,
    render: () => <a>action</a>,
  },
];

const data = [];
for (let i = 0; i < 100; i++) {
  data.push({
    key: i,
    firstname: 'Jacob',
    lastname: 'Yeboah',
    status: 'Technical Interview',
    interested: `Yes`,
    technicalinterview : '24-10-20',
    offerjob: 'Yes',
    accepted: `Yes `,
    keepwarmemail: 'Done',
    keepwarmcall1: 'Done',
    keepwarmcall2: 'Pending',
    notes: 'Quite good and sounds pretty hyped about the opportunity.'
  });
}
const Tables = ()=><Table columns={columns} dataSource={data} scroll={{ x: 1300, y:300 }} />;
export default Tables



