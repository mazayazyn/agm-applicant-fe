import { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import {
  Badge,
  Button,
  Pagination,
  ScrollArea,
  Table,
  Text,
} from "@mantine/core";

export function AdminDashboard() {
  const [vacancies, setVacancies] = useState([]);
  const [page, setPage] = useState(1);
  const [totalPages, setTotalPages] = useState(1);

  const head = (
    <tr>
      <th className="w-2/12">ID</th>
      <th className="w-4/12">Title</th>
      <th className="w-2/6">Last Updated</th>
      <th className="w-2/6">Status</th>
      <th className="w-2/6">Action</th>
    </tr>
  );

  const iconDisplay = (status) => {
    if (status == 1) {
      return <Badge>published</Badge>;
    } else if (status == 2) {
      return <Badge color={"yellow"}>pending</Badge>;
    } else if (status == 3) {
      return <Badge color={"red"}>rejected</Badge>;
    } else if (status == 4) {
      return <Badge color={"gray"}>closed</Badge>;
    }
  };

  const fetchData = async () => {
    await fetch(`/api/v1/admin/get-dashboard?page=${page - 1}`)
      .then((res) => res.json())
      .then((result) => {
        console.log(result);
        const { vacancies, totalPages } = result;
        setVacancies(vacancies);
        setTotalPages(totalPages);
      })
      .catch((err) => {
        console.log(err);
      });
  };

  useEffect(() => {
    fetchData();
  }, [page]);

  return (
    <div className="container mx-auto max-w-screen-xl">
      <div className="flex flex-col mx-2 shadow-lg rounded my-10 border border-gray-200">
        <div className="flex p-5 rounded-t border-b border-gray-200">
          <Text>My Dashboard</Text>
        </div>
        <div className="flex p-5 justify-end">
          <Button component={Link} to={`/u/vacancy/create`}>Create</Button>
        </div>
        <div className="flex p-5">
          <ScrollArea className="w-full">
            <Table>
              {/*  head  */}
              <thead>{head}</thead>
              {/*  body  */}
              <tbody>
                {vacancies.map((data) => {
                  return (
                    <tr key={data[0]}>
                      <td>{data[0]}</td>
                      <td>{data[1]}</td>
                      <td>{data[2]}</td>
                      <td>{iconDisplay(data[3])}</td>
                      <td>
                        <div className="flex space-x-2">
                          <Button component={Link} to={`/u/vacancy/${data[0]}`}>Details</Button>
                          <Button>Candidates</Button>
                        </div>
                      </td>
                    </tr>
                  );
                })}
              </tbody>
            </Table>
          </ScrollArea>
        </div>
        <div className="flex p-5 mb-5 justify-center">
          <Pagination page={page} onChange={setPage} total={totalPages} />
        </div>
      </div>
    </div>
  );
}
