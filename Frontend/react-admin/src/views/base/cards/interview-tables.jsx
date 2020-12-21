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
    // { title: 'Score', width: 150, dataIndex: 'address', key: '1' },
    { title: 'Interview Date', width: 150, dataIndex: 'interviewdate', key: '1' },
    { title: 'Time Phase', width: 150, dataIndex: 'timephase', key: '2' },
    { title: 'Interviewer', width: 150, dataIndex: 'interviewer', key: '3' },
    { title: 'Notes', width: 500, dataIndex: 'notes', key: '4' },
    // { title: 'Interview Notes', width: 150, dataIndex: 'address', key: '3' },
    // { title: 'Interview Notes', width: 150, dataIndex: 'address', key: '3' },
    // { title: 'Interview Notes', width: 150, dataIndex: 'address', key: '3' },
    // { title: 'Interview Notes', width: 150, dataIndex: 'address', key: '3' },
    // { title: 'Interview Notes', width: 150, dataIndex: 'address', key: '3' },


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
    firstname: `Yvette`,
    lastname: 'Koranteng',
    status: 'Technical Interview',
    interviewdate: `20-10-20`,
    timephase: 'Late PM',
    interviewer:'Sam',
    notes: 'Intelligient and intriguing but still in school.'
  });
}
const InterviewTables = ()=><Table columns={columns} dataSource={data} scroll={{ x: 1300, y:300 }} />;
export default InterviewTables



