import { Landing } from "@/components/Landing/Index";
import { ActionIcon, Button } from "@mantine/core";
import { ChevronLeft } from "tabler-icons-react";
import { useParams, useNavigate } from "react-router-dom";

export function DetailVacancy() {
  let { id } = useParams();
  let navigate = useNavigate();

  return (
    <Landing>
      <div className="flex flex-col w-full border-b border-gray-200 justify-end h-32">
        <div className="container max-w-screen-xl mx-auto">
          <div className="flex py-4 px-5 gap-x-2">
            <ActionIcon
              variant="transparent"
              onClick={() => navigate(`/u/dashboard`)}
            >
              <ChevronLeft />
            </ActionIcon>
            <div className="text text-lg font-semibold">Details</div>
          </div>
        </div>
      </div>
      <div className="flex">
        <div className="container max-w-screen-xl mx-auto">
          <div className="flex py-4 px-5 justify-between items-center">
            <div className="flex">
              <div className="text text-2xl">{`Request #${id}`}</div>
            </div>
            <div className="flex space-x-2">
              <Button onClick={() => navigate(`/u/vacancy/edit/${id}`)}>
                Edit
              </Button>
              <Button>Publish</Button>
            </div>
          </div>
        </div>
      </div>
    </Landing>
  );
}
