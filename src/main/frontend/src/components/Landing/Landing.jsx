import { AppShell, Navbar, Header, Button } from "@mantine/core";
import { default as logo } from "@/assets/header_logo.svg";
import { Link } from "react-router-dom";

export function Landing({ children }) {
  return (
    <AppShell
      padding={0}
      header={
        <Header p="xs" fixed>
          <div className="container mx-auto max-w-screen-xl h-12 px-1">
            <div className="flex justify-between items-center">
              <img src={logo} width="184" />
              <Button variant="subtle" component={Link} to="/u/dashboard">Dashboard</Button>
            </div>
          </div>
        </Header>
      }
    >
      {children}
    </AppShell>
  );
}
