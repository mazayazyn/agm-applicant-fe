import { Landing } from "@/components/Landing/Index";
import { ActionIcon } from "@mantine/core";
import { Link } from "react-router-dom";
import { ChevronLeft } from "tabler-icons-react";
import { VacancyForm } from "@/components/Form/Vacancy/Index";

export function CreateVacancy() {
  return (
    <Landing>
      <div className="flex flex-col w-full border-b border-gray-200 justify-end h-32">
        <div className="container max-w-screen-xl mx-auto">
          <div className="flex py-4 px-5 gap-x-2">
            <ActionIcon variant="transparent" component={Link} to="/u/dashboard">
              <ChevronLeft/>
            </ActionIcon>
            <div className="text text-lg font-semibold">
              Request Forms
            </div>
          </div>
        </div>
      </div>
      <VacancyForm/>
    </Landing>
  );
}
