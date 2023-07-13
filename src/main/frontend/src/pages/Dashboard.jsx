import { Landing } from "@/components/Landing/Index";
import { AdminDashboard } from "@/components/Table/Index";

export function Dashboard() {
  return (
    <Landing>
      <div className="flex flex-col w-full border-b border-gray-200 justify-end h-32">
        <div className="container max-w-screen-xl mx-auto">
          <div className="text text-lg py-4 px-5 font-semibold">Dashboard</div>
        </div>
      </div>
      <AdminDashboard/>
    </Landing>
  );
}